package egovframework.com.cmm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.querydsl.core.util.StringUtils;

@Component
public class CSRFInterceptor implements HandlerInterceptor {

    private static final String CSRF_TOKEN_ATTR_NAME = "CSRF_TOKEN";
    private static final String CSRF_TOKEN_HEADER = "X-CSRF-Token";
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // GET 요청은 검증하지 않음
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        
        HttpSession session = request.getSession(false);
        
        // POST, PUT, DELETE 요청에 대해 CSRF 토큰 검증 수행
        if (session == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF token missing or invalid.");
            return false;
        }

        String sessionToken = (String) session.getAttribute(CSRF_TOKEN_ATTR_NAME);
        String requestToken = request.getHeader(CSRF_TOKEN_HEADER);
        if (StringUtils.isNullOrEmpty(requestToken) || requestToken == "undefined") {
        	requestToken = (String) request.getParameter(CSRF_TOKEN_ATTR_NAME); 
        }
        
        if (sessionToken == null || requestToken == null || !sessionToken.equals(requestToken)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF token mismatch.");
            return false;
        }
        
        return true;
    }
    
}
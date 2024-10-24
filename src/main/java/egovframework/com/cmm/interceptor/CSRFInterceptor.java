package egovframework.com.cmm.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.querydsl.core.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CSRFInterceptor implements HandlerInterceptor {

    private static final String CSRF_TOKEN_ATTR_NAME = "CSRF_TOKEN";
    private static final String CSRF_TOKEN_HEADER = "X-CSRF-Token";
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // GET 요청은 검증하지 않음
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        
        log.info("========================================================");
		log.info(" Start CSRF Certification!!!");
        
        HttpSession session = request.getSession();
        
        String sessionToken = (String) session.getAttribute(CSRF_TOKEN_ATTR_NAME);
        String requestToken = request.getHeader(CSRF_TOKEN_HEADER);
        
        if (StringUtils.isNullOrEmpty(requestToken) || requestToken == "undefined") {
        	requestToken = (String) request.getParameter(CSRF_TOKEN_ATTR_NAME); 
        }
        
        if (sessionToken == null || requestToken == null || !sessionToken.equals(requestToken)) {

        	log.info(" Fail Certification!!!");
        	log.info("========================================================");
        	
        	// handler가 HandlerMethod의 인스턴스인지 확인
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;

                // 컨트롤러 클래스 가져오기
                Class<?> controllerClass = handlerMethod.getBeanType();

                // 컨트롤러 클래스가 @RestController로 어노테이션되어 있는지 확인
                if (controllerClass.isAnnotationPresent(RestController.class)) {
                	
                	try {
    	        		response.setContentType("application/json");
    	                response.getOutputStream().write("FAIL_CSRFCERT".getBytes());
            		} catch (Exception e) {
            			throw new ServletException(e);
            		}
                
                // 컨트롤러 클래스가 @Controller로 어노테이션되어 있는지 확인	
                } else if (controllerClass.isAnnotationPresent(Controller.class)) {
                    
                	ModelAndView modelAndView = new ModelAndView("/error/error_auth");
            		modelAndView.addObject("errorTitle", "Fail CSRF Certification!!");
            		modelAndView.addObject("errorMessage", "CSRF authentication failed. Please contact the administrator.");
            		
            		throw new ModelAndViewDefiningException(modelAndView);
                	
                }
            }
            
            return false;
        	
        }
        
        log.info(" Success Certification!!!");
    	log.info("========================================================");

        return true;
        
    }
    
}
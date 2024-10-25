package egovframework.com.cmm.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.Base64;

@Component
public class NonceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 랜덤하게 nonce 생성
        SecureRandom random = new SecureRandom();
        byte[] nonceBytes = new byte[16];
        random.nextBytes(nonceBytes);
        String nonce = Base64.getEncoder().encodeToString(nonceBytes);

        // 요청 속성에 nonce 저장
        request.setAttribute("nonce", nonce);
        response.setHeader("Content-Security-Policy", "script-src 'self' 'nonce-" + nonce + "'");

        return true;
    }
}
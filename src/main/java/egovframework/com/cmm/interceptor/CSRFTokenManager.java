package egovframework.com.cmm.interceptor;

import java.util.UUID;
import javax.servlet.http.HttpSession;

public class CSRFTokenManager {

    private static final String CSRF_TOKEN_ATTR = "CSRF_TOKEN";

    // 세션에 CSRF 토큰을 저장하고 반환
    public static String getTokenForSession(HttpSession session, boolean renew) {
        String token = (String) session.getAttribute(CSRF_TOKEN_ATTR);
        if (renew) {
        	token = UUID.randomUUID().toString();  // 랜덤한 CSRF 토큰 생성
            session.setAttribute(CSRF_TOKEN_ATTR, token);  // 세션에 토큰 저장
        }
        return token;
    }
}
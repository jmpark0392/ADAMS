/**
 * 
 */
package egovframework.com.cmm.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.WebContentInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JeongHyunseung
 *
 */
@Slf4j
public class BusinessInterceptor extends WebContentInterceptor {
	
	/**
	 * 세션에 계정정보(LoginVO)가 있는지 여부로 인증 여부를 체크한다.
	 * 계정정보(LoginVO)가 없다면, 로그인 페이지로 이동한다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {

		
    
		return true;
		
	}

}
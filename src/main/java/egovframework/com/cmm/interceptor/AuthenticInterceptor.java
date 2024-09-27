package egovframework.com.cmm.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;
import com.rds.adams.web.core.utils.StringUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 인증여부 체크 인터셉터
 * @author 공통서비스 개발팀 서준식
 * @since 2011.07.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2011.07.01  서준식          최초 생성
 *  2011.09.07  서준식          인증이 필요없는 URL을 패스하는 로직 추가
 *  2014.06.11  이기하          인증이 필요없는 URL을 패스하는 로직 삭제(xml로 대체)
 *  </pre>
 */
@Slf4j
@Component
public class AuthenticInterceptor extends WebContentInterceptor {

	/**
	 * 세션에 계정정보(LoginVO)가 있는지 여부로 인증 여부를 체크한다.
	 * 계정정보(LoginVO)가 없다면, 로그인 페이지로 이동한다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
		
		List<String> exceptPageNameList = new ArrayList<>();
		
		// 패턴으로 예외처리 안되는 페이지들은 exceptPageNameList로 리스트를 관리
		exceptPageNameList.add("/login");
		exceptPageNameList.add("/subscription");
		exceptPageNameList.add("/views/user/myPage");
		
		exceptPageNameList.add("myPage");
		exceptPageNameList.add("newReq");
		exceptPageNameList.add("pwReset");
		exceptPageNameList.add("login");
		exceptPageNameList.add("pwChange");
		
		exceptPageNameList.add("/error/error_400");
		exceptPageNameList.add("/error/error_500");
		exceptPageNameList.add("/error/error_auth");
		
		String pageName = request.getParameter("pageName");
		
		log.info("========================================================");
		log.info(" AuthenticationInterceptor [URI : "+request.getRequestURI()+"]");
		log.info(" AuthenticationInterceptor [Requested Page : "+pageName+"]");
		
		// 세션을 따로 가져온 후 등록된 정보를 토대로 인증 
    	HttpSession session = request.getSession();
    	AdamsLoginDTO loginVO = (AdamsLoginDTO) session.getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
    	
    	// 패턴으로 예외처리 안되는 페이지들은 exceptPageNameList로 리스트를 관리
        if (exceptPageNameList.contains(pageName)) {
        	
        	return true;
        	
        } else {
        	
        	if (loginVO == null || StringUtil.isEmpty(loginVO.getUsrId())) {
        		
        		log.debug("AuthenticInterceptor Fail!!!!!!!!!!!!================== ");
            	
        		ModelAndView modelAndView = new ModelAndView("/error/error_auth");
        		modelAndView.addObject("errorTitle", "Authentication Fail!!");
        		modelAndView.addObject("errorMessage", "AuthenticInterceptor Fail!!!!!!!!!!!!");
        		
        		throw new ModelAndViewDefiningException(modelAndView);
        		
        	} else {
        		
    			log.debug("loginVO:", loginVO.toString());
    			log.debug("AuthenticInterceptor sessionID "+loginVO.getUsrId());
    			log.debug("AuthenticInterceptor ================== ");
    			return true;
    			
    		}
    		
        }
        
	}
}
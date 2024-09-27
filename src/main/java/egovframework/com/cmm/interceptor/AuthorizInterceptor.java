package egovframework.com.cmm.interceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.login.dto.AdamsMenuDTO;
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
@SuppressWarnings("unchecked")
public class AuthorizInterceptor extends WebContentInterceptor {
	
	/*
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
		return true;
	}
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
		log.info(" AuthorizationInterceptor [URI : "+request.getRequestURI()+"]");
		log.info(" AuthorizationInterceptor [Requested Page : "+pageName+"]");
		
		// 세션을 따로 가져온 후 등록된 정보를 토대로 인증 
    	String menuId = getMenuIdByUrl(request);
    	
    	log.info(" menuId [Data : "+menuId+"]");
    	
    	// 패턴으로 예외처리 안되는 페이지들은 exceptPageNameList로 리스트를 관리
        if (exceptPageNameList.contains(pageName)) {
        	return true;
        }
        else if (StringUtil.isEmpty(menuId)) {
        	try {
				response.sendError(404, menuId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		return false;
    	}
    	return true;
	}
	
	private String getMenuIdByUrl(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String uri = request.getParameter("pageName");
		
		List<AdamsMenuDTO> menuList = (List<AdamsMenuDTO>) session.getAttribute(AdamsConstant.SESSION_MENU_FLATLIST);
		String menuId = "";
		
		if (menuList == null || menuList.size() <= 0) {
			return "";
		} else {
			for (AdamsMenuDTO menuDTO : menuList) {
				if (menuDTO.getPgmUrl().equals(uri)) {
					menuId = menuDTO.getMenuId();
				}
			}
		}
		
		return menuId;
		
	}
}
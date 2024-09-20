/**
 * 
 */
package egovframework.com.cmm.interceptor;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.login.dto.AdamsMenuDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JeongHyunseung
 *
 */
@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BusinessInterceptor extends WebContentInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		String uri = request.getRequestURI();
		log.info("========================================================");
		log.info(" BusinessInterceptor [URI : "+uri+"]");
		
		HttpSession session = request.getSession();
		List<AdamsMenuDTO> menuList = (List<AdamsMenuDTO>) session.getAttribute(AdamsConstant.SESSION_MENU_TREELIST);
		
		String menuId = getMenuIdByUrl(request);
		
		log.info(" AdamsMenuDTO [Data : "+menuId+"]");

		if (modelAndView != null) {
			modelAndView.addObject("menuList", menuList);
			modelAndView.addObject("menuId", menuId);
		}
		
		log.info("========================================================");
		
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
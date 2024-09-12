/**
 * 
 */
package egovframework.com.cmm.interceptor;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.rds.adams.web.common.login.dto.AdamsMenuDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JeongHyunseung
 *
 */
@Slf4j
@SuppressWarnings("unchecked")
public class BusinessInterceptor extends WebContentInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		log.info("========================================================");
		log.info(" BusinessInterceptor [URI : "+request.getRequestURI()+"]");
		
		HttpSession session = request.getSession();
		List<AdamsMenuDTO> menuList = (List<AdamsMenuDTO>) session.getAttribute("MenuTreeVOList");
		
		String menuId = "";

		if (modelAndView != null) {
			modelAndView.addObject("menuList", menuList);
		}
		
		log.info("========================================================");
		
	}
	
	private String getMenuIdByUrl(String url, HttpSession session) {
		
		List<AdamsMenuDTO> menuList = (List<AdamsMenuDTO>) session.getAttribute("MenuTreeVOList");
		return null;
	}

}
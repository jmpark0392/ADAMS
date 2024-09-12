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
		List<AdamsMenuDTO> menuList = (List<AdamsMenuDTO>) session.getAttribute("MenuVOList");
		
		//List<AdamsMenuDTO> menuList = new ArrayList<AdamsMenuDTO>();
		//List<AdamsMenuDTO> subMenuList = new ArrayList<AdamsMenuDTO>();
		//
		//AdamsMenuDTO sub1 = new AdamsMenuDTO();
		//sub1.setPgmUrl("/views/wrk/fil/WRKFIL001M0");
		//sub1.setMenuNmEng("File");
		//AdamsMenuDTO sub2 = new AdamsMenuDTO();
		//sub2.setPgmUrl("/views/wrk/fil/WRKFIL002M0");
		//sub2.setMenuNmEng("Column");
		//AdamsMenuDTO sub3 = new AdamsMenuDTO();
		//sub3.setPgmUrl("/views/wrk/fil/WRKFIL003M0");
		//sub3.setMenuNmEng("Upload");
		//AdamsMenuDTO sub4 = new AdamsMenuDTO();
		//sub4.setPgmUrl("/views/wrk/fil/WRKFIL004M0");
		//sub4.setMenuNmEng("History");
		//
		//subMenuList.add(sub1);
		//subMenuList.add(sub2);
		//subMenuList.add(sub3);
		//subMenuList.add(sub4);
		//
		//AdamsMenuDTO main = new AdamsMenuDTO();
		//main.setMenuId("101000000");
		//main.setMenuNmEng("Input Files");
		//main.setSubMenuList(subMenuList);
		//
		//menuList.add(main);
		
		if (modelAndView != null) {
			modelAndView.addObject("menuList", menuList);
		}
		
		log.info("========================================================");
		
	}

}
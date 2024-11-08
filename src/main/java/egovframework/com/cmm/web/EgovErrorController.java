/**
 * 
 */
package egovframework.com.cmm.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JeongHyunseung
 *
 */
@Slf4j
@Controller
public class EgovErrorController implements ErrorController {

	@RequestMapping(value = "/error")
	public String handleError(HttpServletRequest request) {
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			
			int statusCode = Integer.valueOf(status.toString()).intValue();
			log.debug(""+statusCode);
			
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return "/error/error_400";
			} else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				return "/error/error_400";
			} else if(statusCode == HttpStatus.SERVICE_UNAVAILABLE.value()) {
				return "/error/error_500";
			} else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "/error/error_500";
			} else {
				return "/error/error";
			}
			
		}
		
		return "/error/error";
	}
}
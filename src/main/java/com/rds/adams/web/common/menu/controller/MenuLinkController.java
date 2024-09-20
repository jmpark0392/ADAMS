/**
 * 
 */
package com.rds.adams.web.common.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JeongHyunseung
 *
 */
@Slf4j
@Controller
public class MenuLinkController {
	
	@PostMapping("/menuLink")
	public String goMenuPage(@RequestBody String pageName) {
		log.debug("##################### pageName : ["+pageName.split("=")[1]+"] #####################");
		
		String newPageName = pageName.split("=")[1];
		
		if ( "myPage".equals(newPageName) ) {
			return "views/user/myPage";
		}
		if ( "pwChange".equals(newPageName) ) {
			return "/views/user/newPassword";
		}
		if ( "newReq".equals(newPageName) ) {
			return "/views/user/newCompany";
		}
		if ( "pwReset".equals(newPageName) ) {
			return "/views/user/passwordReset";
		}
		if ( "login".equals(newPageName) ) {
			return "/login";
		}
		
		return newPageName.replaceAll("%2F", "/");
	}

}
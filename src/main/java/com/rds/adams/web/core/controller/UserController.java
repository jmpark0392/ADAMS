package com.rds.adams.web.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.core.dto.TbUserDto;
import com.rds.adams.web.core.service.UserService;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 1. 18.
 * @author : JEONG HYEONSEUNG
 * E-MAIL  : hs.jeong@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-01-18 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * @param inDto
	 * @return com.rds.adams.web.core.dto.TbUserDto
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 * USER_ID에 해당하는 USER정보를 조회하는 Controller Method 
	 * ----------------------------------------------------
	 * </PRE>
	 */
	@RequestMapping(value="/selectUserByUserId", method=RequestMethod.POST, consumes="application/json")
	public TbUserDto selectUserByUserId(@RequestBody TbUserDto inDto) {
		return userService.selectUserByUserId(inDto);
	}
	
	/**
	 * @param inDto
	 * @return
	 * @throws Exception
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 *
	 * ----------------------------------------------------
	 * </PRE>
	 */
	@RequestMapping(value="/saveUser", method=RequestMethod.POST, consumes="application/json")
	public TbUserDto saveUser(@RequestBody TbUserDto inDto) throws Exception {

		TbUserDto outDto = userService.selectUserByUserId(inDto);
		int result = 0;
		
		if (outDto != null) {
			result = userService.updateUser(inDto);
		} else {
			result = userService.insertUser(inDto);
		}
		
		if (result <= 0) {
			throw new Exception();
		}
		
		return inDto;
		
	}

}
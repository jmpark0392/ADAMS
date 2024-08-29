package com.rds.adams.web.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.core.dto.TbUserRoleDto;
import com.rds.adams.web.core.service.UserRoleService;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 1. 19.
 * @author : JEONG HYEONSEUNG
 * E-MAIL  : hs.jeong@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-01-19 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@RestController
public class UserRoleController {
	
	@Autowired
	UserRoleService userRoleService;
	
	/**
	 * @param inDto
	 * @return List<com.rds.adams.web.core.dto.TbUserRoleDto>
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 *
	 * ----------------------------------------------------
	 * </PRE>
	 */
	@RequestMapping(value="/selectListUserRoleByUserId", method=RequestMethod.POST, consumes="application/json")
	public List<TbUserRoleDto> selectListUserRoleByUserId(TbUserRoleDto inDto) {
		return userRoleService.selectListUserRoleByUserId(inDto);
	}
	
	/**
	 * @param inDto
	 * @return com.rds.adams.web.core.dto.TbUserRoleDto
	 * @throws Exception
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 *
	 * ----------------------------------------------------
	 * </PRE>
	 */
	@RequestMapping(value="/saveUserRole", method=RequestMethod.POST, consumes="application/json")
	public TbUserRoleDto saveUserRole(TbUserRoleDto inDto) throws Exception {
		
		TbUserRoleDto outDto = userRoleService.selectUserRoleByUserIdRoleId(inDto);
		int result = 0;
		
		if (outDto != null) {
			result = userRoleService.updateUserRole(inDto);
		} else {
			result = userRoleService.insertUserRole(inDto);
		}
		
		if (result <=0 ) {
			throw new Exception();
		}
		
		return inDto;
		
	}

}
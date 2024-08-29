package com.rds.adams.web.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.core.dto.TbRoleDto;
import com.rds.adams.web.core.service.RoleService;

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
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="/saveRole", method=RequestMethod.POST, consumes="application/json")
	public TbRoleDto saveRole(TbRoleDto inDto) throws Exception {
		
		TbRoleDto outDto = roleService.selectRoleByRoleId(inDto);
		int result = 0;
		
		if (outDto == null) {
			result = roleService.insertRole(inDto);
		} else {
			result = roleService.updateRole(inDto);
		}
		
		if (result <= 0) {
			throw new Exception();
		}
		
		return inDto;
		
	}
}

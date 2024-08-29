package com.rds.adams.web.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.core.dao.TbRoleDao;
import com.rds.adams.web.core.dto.TbRoleDto;

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
@Service
public class RoleService {
	
	@Autowired
	TbRoleDao tbRoleDao;
	
	/**
	 * @param inDto
	 * @return int
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 *
	 * ----------------------------------------------------
	 * </PRE>
	 */
	public int insertRole(TbRoleDto inDto) {
		return tbRoleDao.insertRole(inDto);
	}
	
	/**
	 * @param inDto
	 * @return int
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 *
	 * ----------------------------------------------------
	 * </PRE>
	 */
	public int updateRole(TbRoleDto inDto) {
		return tbRoleDao.updateRole(inDto);
	}
	
	/**
	 * @param inDto
	 * @return
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 *
	 * ----------------------------------------------------
	 * </PRE>
	 */
	public TbRoleDto selectRoleByRoleId(TbRoleDto inDto) {
		return tbRoleDao.selectRoleByRoleId(inDto);
	}

}
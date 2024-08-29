package com.rds.adams.web.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.core.dao.TbUserRoleDao;
import com.rds.adams.web.core.dto.TbUserRoleDto;

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
public class UserRoleService {
	
	@Autowired
	TbUserRoleDao tbUserRoleDao;
	
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
	public int insertUserRole(TbUserRoleDto inDto) {
		return tbUserRoleDao.insertUserRole(inDto);
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
	public int updateUserRole(TbUserRoleDto inDto) {
		return tbUserRoleDao.updateUserRole(inDto);
	}
	
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
	public List<TbUserRoleDto> selectListUserRoleByUserId(TbUserRoleDto inDto) {
		return tbUserRoleDao.selectListUserRoleByUserId(inDto);
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
	public TbUserRoleDto selectUserRoleByUserIdRoleId(TbUserRoleDto inDto) {
		return tbUserRoleDao.selectUserRoleByUserIdRoleId(inDto);
	}

}

package com.rds.adams.web.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface TbUserRoleDao {

	/**
	 * @param indto
	 * @return int
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 *
	 * ----------------------------------------------------
	 * </PRE>
	 */
	public int insertUserRole(TbUserRoleDto indto);
	
	/**
	 * @param indto
	 * @return int
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 *
	 * ----------------------------------------------------
	 * </PRE>
	 */
	public int updateUserRole(TbUserRoleDto indto);
	
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
	public List<TbUserRoleDto> selectListUserRoleByUserId(TbUserRoleDto inDto);
	
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
	public TbUserRoleDto selectUserRoleByUserIdRoleId(TbUserRoleDto inDto);
	
}

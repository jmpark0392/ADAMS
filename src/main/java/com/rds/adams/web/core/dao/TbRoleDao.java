package com.rds.adams.web.core.dao;

import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface TbRoleDao {
	
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
	public int insertRole(TbRoleDto inDto);
	
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
	public int updateRole(TbRoleDto inDto);
	
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
	public TbRoleDto selectRoleByRoleId(TbRoleDto inDto);

}
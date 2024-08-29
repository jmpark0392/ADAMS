package com.rds.adams.web.core.dao;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.core.dto.TbUserDto;

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
public interface TbUserDao {
	
	/**
	 * @param inDto
	 * @return com.rds.adams.web.core.dto.TbUserDto
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 * USER_ID에 해당하는 USER정보를 조회하는 DAO Method
	 * ----------------------------------------------------
	 * </PRE>
	 */
	public TbUserDto selectUserByUserId(TbUserDto inDto);
	
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
	public int insertUser(TbUserDto inDto);
	
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
	public int updateUser(TbUserDto inDto);

}
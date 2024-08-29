package com.rds.adams.web.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.core.dao.TbUserDao;
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
@Service
public class UserService {
	
	@Autowired
	TbUserDao tbUserDao;
	
	/**
	 * @param inDto
	 * @return com.rds.adams.web.core.dto.TbUserDto
	 *
	 * <PRE>
	 * DESCRIPTION
	 * ----------------------------------------------------
	 * USER_ID에 해당하는 USER정보를 조회하는 Service Method
	 * ----------------------------------------------------
	 * </PRE>
	 */
	public TbUserDto selectUserByUserId(TbUserDto inDto) {
		return tbUserDao.selectUserByUserId(inDto);
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
	public int insertUser(TbUserDto inDto) {
		return tbUserDao.insertUser(inDto);
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
	public int updateUser(TbUserDto inDto) {
		return tbUserDao.updateUser(inDto);
	}

}
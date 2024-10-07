package com.rds.adams.web.biz.ins.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.biz.ins.dto.BIZINS002M0P0DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS002M0P1DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS002M0R0DTO;

@Mapper
public interface BIZINS002M0DAO {
	
	public List<BIZINS002M0R0DTO> selectList(BIZINS002M0P0DTO inVo);
	
	public void deleteListBf(BIZINS002M0P1DTO inVo);
	
	public void insertList(BIZINS002M0P1DTO inVo);
}
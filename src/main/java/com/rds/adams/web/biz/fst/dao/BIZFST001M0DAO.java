package com.rds.adams.web.biz.fst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.biz.fst.dto.BIZFST001M0P0DTO;
import com.rds.adams.web.biz.fst.dto.BIZFST001M0P1DTO;
import com.rds.adams.web.biz.fst.dto.BIZFST001M0R0DTO;

@Mapper
public interface BIZFST001M0DAO {
	
	public List<BIZFST001M0R0DTO> selectList(BIZFST001M0P0DTO inVo);
	
	public void deleteListBf(BIZFST001M0P1DTO inVo);
	
	public void insertList(BIZFST001M0P1DTO inVo);
}
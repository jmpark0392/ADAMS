package com.rds.adams.web.biz.ins.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.biz.ins.dto.BIZINS003M0P0DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS003M0P1DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS003M0R0DTO;

@Mapper
public interface BIZINS003M0DAO {
	
	public List<BIZINS003M0R0DTO> selectList(BIZINS003M0P0DTO inVo);

	public void deleteListBf(BIZINS003M0P1DTO inVo);
	
	public void insertList(BIZINS003M0P1DTO inVo);
}
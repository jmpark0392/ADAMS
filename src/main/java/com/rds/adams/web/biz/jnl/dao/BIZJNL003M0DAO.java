package com.rds.adams.web.biz.jnl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.biz.jnl.dto.BIZJNL003M0P0DTO;
import com.rds.adams.web.biz.jnl.dto.BIZJNL003M0P1DTO;
import com.rds.adams.web.biz.jnl.dto.BIZJNL003M0R0DTO;

@Mapper
public interface BIZJNL003M0DAO {
	
	public List<BIZJNL003M0R0DTO> selectList(BIZJNL003M0P0DTO inVo);

	public void insertList(BIZJNL003M0P1DTO inVo);
	
	public void deleteList(BIZJNL003M0P1DTO inVo);
	
}
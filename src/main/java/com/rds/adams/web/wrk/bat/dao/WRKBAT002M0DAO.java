package com.rds.adams.web.wrk.bat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.wrk.bat.dto.WRKBAT002M0P0DTO;
import com.rds.adams.web.wrk.bat.dto.WRKBAT002M0R0DTO;

@Mapper
public interface WRKBAT002M0DAO {
	
	public List<WRKBAT002M0R0DTO> selectList(WRKBAT002M0P0DTO inVo);
	
	
}
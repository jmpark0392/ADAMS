package com.rds.adams.web.MST.SYS.dao;

import java.util.List;

//import org.apache.ibatis.annotations.Mapper;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import org.springframework.stereotype.Repository;

import com.rds.adams.web.MST.SYS.dto.MSTSYS002M0P0DTO;
import com.rds.adams.web.MST.SYS.dto.MSTSYS002M0P1DTO;
import com.rds.adams.web.MST.SYS.dto.MSTSYS002M0R0DTO;

@Mapper
public interface MSTSYS002M0DAO {
	
	public List<MSTSYS002M0R0DTO> selectList(MSTSYS002M0P0DTO inVo);
	
	public void insertList(MSTSYS002M0P1DTO inVo);
	
	public void updateList(MSTSYS002M0P1DTO inVo);
}
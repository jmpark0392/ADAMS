package com.rds.adams.web.MST.SYS.dao;

import java.util.List;

//import org.apache.ibatis.annotations.Mapper;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import org.springframework.stereotype.Repository;

import com.rds.adams.web.MST.SYS.dto.MSTSYS002M1P0DTO;
import com.rds.adams.web.MST.SYS.dto.MSTSYS002M1P1DTO;
import com.rds.adams.web.MST.SYS.dto.MSTSYS002M1R0DTO;

@Mapper
public interface MSTSYS002M1DAO {
	
	public List<MSTSYS002M1R0DTO> selectList(MSTSYS002M1P0DTO inVo);
	
	public void multipleInsertList(List<MSTSYS002M1P1DTO> inVo);
	
	public void multipleUpdateList(List<MSTSYS002M1P1DTO> inVo);
}
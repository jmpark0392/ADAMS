package com.rds.adams.web.WRK.FIL.dao;

import java.util.List;

//import org.apache.ibatis.annotations.Mapper;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M0P0DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M0P1DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M0P2DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M0R0DTO;

@Mapper
public interface WRKFIL002M0DAO {
	
	public List<WRKFIL002M0R0DTO> selectList(WRKFIL002M0P0DTO inVo);
	
	public void insertList(WRKFIL002M0P1DTO inVo);
	
	public void updateList(WRKFIL002M0P1DTO inVo);
	
	public void deleteList(WRKFIL002M0P2DTO inVo);
}
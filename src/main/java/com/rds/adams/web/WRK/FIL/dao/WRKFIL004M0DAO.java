package com.rds.adams.web.WRK.FIL.dao;

import java.util.List;

//import org.apache.ibatis.annotations.Mapper;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import com.rds.adams.web.WRK.FIL.dto.WRKFIL004M0P0DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL004M0R0DTO;

@Mapper
public interface WRKFIL004M0DAO {
	
	public List<WRKFIL004M0R0DTO> selectList(WRKFIL004M0P0DTO inVo);

}
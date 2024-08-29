package com.rds.adams.web.WRK.FIL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.WRK.FIL.dao.WRKFIL001M0DAO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL001M0P0DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL001M0P1DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL001M0R0DTO;

@Service
public final class WRKFIL001M0Service {
	
	@Autowired
	WRKFIL001M0DAO wRKFIL001M0DAO;
	
	public List<WRKFIL001M0R0DTO> selectList(WRKFIL001M0P0DTO inVo) {
		
		return wRKFIL001M0DAO.selectList(inVo);
		
	}
	
	public void insertList(WRKFIL001M0P1DTO inVo) {
		wRKFIL001M0DAO.insertList(inVo);
	}
	
	public void updateList(WRKFIL001M0P1DTO inVo) {
		wRKFIL001M0DAO.updateList(inVo);
	}
}
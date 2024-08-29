package com.rds.adams.web.WRK.BAT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rds.adams.web.WRK.BAT.dao.WRKBAT003M0DAO;
import com.rds.adams.web.WRK.BAT.dto.WRKBAT003M0P0DTO;
import com.rds.adams.web.WRK.BAT.dto.WRKBAT003M0R0DTO;

@Service
public class WRKBAT003M0Service {
	
	@Autowired
	WRKBAT003M0DAO wRKBAT003M0DAO;

	public List<WRKBAT003M0R0DTO> selectList(WRKBAT003M0P0DTO inVo) {
	
		return wRKBAT003M0DAO.selectList(inVo);
	}

}

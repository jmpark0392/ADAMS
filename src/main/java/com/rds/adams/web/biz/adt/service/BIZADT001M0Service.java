package com.rds.adams.web.biz.adt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.biz.adt.dao.BIZADT001M0DAO;
import com.rds.adams.web.biz.adt.dto.BIZADT001M0P0DTO;
import com.rds.adams.web.biz.adt.dto.BIZADT001M0P1DTO;
import com.rds.adams.web.biz.adt.dto.BIZADT001M0R0DTO;

@Service
public class BIZADT001M0Service {
	
	@Autowired
	BIZADT001M0DAO bIZADT001M0DAO;
	
	public List<BIZADT001M0R0DTO> selectList(BIZADT001M0P0DTO inVo) {
		
		return bIZADT001M0DAO.selectList(inVo);
	}
	
	public void executeList(BIZADT001M0P1DTO inVo) {
		bIZADT001M0DAO.deleteList(inVo);
		bIZADT001M0DAO.insertList(inVo);
	}
	
}
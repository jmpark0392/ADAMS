package com.rds.adams.web.biz.fst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.biz.fst.dao.BIZFST001M0DAO;
import com.rds.adams.web.biz.fst.dto.BIZFST001M0P0DTO;
import com.rds.adams.web.biz.fst.dto.BIZFST001M0R0DTO;

@Service
public class BIZFST001M0Service {
	
	@Autowired
	BIZFST001M0DAO bIZFST001M0DAO;
	
	public List<BIZFST001M0R0DTO> selectList(BIZFST001M0P0DTO inVo) {
		
		return bIZFST001M0DAO.selectList(inVo);
		
	}
	
}
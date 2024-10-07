package com.rds.adams.web.biz.fst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.biz.fst.dao.BIZFST002M0DAO;
import com.rds.adams.web.biz.fst.dto.BIZFST002M0P0DTO;
import com.rds.adams.web.biz.fst.dto.BIZFST002M0P1DTO;
import com.rds.adams.web.biz.fst.dto.BIZFST002M0R0DTO;

@Service
public class BIZFST002M0Service {
	
	@Autowired
	BIZFST002M0DAO bIZFST002M0DAO;
	
	public List<BIZFST002M0R0DTO> selectList(BIZFST002M0P0DTO inVo) {
		
		return bIZFST002M0DAO.selectList(inVo);
		
	}
	public void executeList(BIZFST002M0P1DTO inVo) {
		bIZFST002M0DAO.deleteListBf(inVo);
		bIZFST002M0DAO.insertList(inVo);
		
		return;
	}
}
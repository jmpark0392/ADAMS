package com.rds.adams.web.biz.ins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rds.adams.web.biz.ins.dao.BIZINS002M0DAO;
import com.rds.adams.web.biz.ins.dto.BIZINS002M0P0DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS002M0P1DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS002M0R0DTO;

@Service
public class BIZINS002M0Service {
	
	@Autowired
	BIZINS002M0DAO bIZINS002M0DAO;
	
	public List<BIZINS002M0R0DTO> selectList(BIZINS002M0P0DTO inVo) {
		return bIZINS002M0DAO.selectList(inVo);
	}
	
	public void executeList(BIZINS002M0P1DTO inVo) {
		bIZINS002M0DAO.deleteListBf(inVo);
		bIZINS002M0DAO.insertList(inVo);
		
		return;
	}
}
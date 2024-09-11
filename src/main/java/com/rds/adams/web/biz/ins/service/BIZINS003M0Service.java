package com.rds.adams.web.biz.ins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.biz.ins.dao.BIZINS003M0DAO;
import com.rds.adams.web.biz.ins.dto.BIZINS003M0P0DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS003M0R0DTO;

@Service
public class BIZINS003M0Service {
	
	@Autowired
	BIZINS003M0DAO bIZINS003M0DAO;
	
	public List<BIZINS003M0R0DTO> selectList(BIZINS003M0P0DTO inVo) {
		
		return bIZINS003M0DAO.selectList(inVo);
		
	}
	
}
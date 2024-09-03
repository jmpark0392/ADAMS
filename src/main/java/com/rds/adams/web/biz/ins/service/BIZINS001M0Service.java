package com.rds.adams.web.biz.ins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.biz.ins.dao.BIZINS001M0DAO;
import com.rds.adams.web.biz.ins.dto.BIZINS001M0P0DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS001M0R0DTO;

@Service
public class BIZINS001M0Service {
	
	@Autowired
	BIZINS001M0DAO bIZINS001M0DAO;
	
	public List<BIZINS001M0R0DTO> selectList(BIZINS001M0P0DTO inVo) {
		
		return bIZINS001M0DAO.selectList(inVo);
		
	}
	
}
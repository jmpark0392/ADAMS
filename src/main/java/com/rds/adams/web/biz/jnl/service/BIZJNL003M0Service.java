package com.rds.adams.web.biz.jnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.biz.jnl.dao.BIZJNL003M0DAO;
import com.rds.adams.web.biz.jnl.dto.BIZJNL003M0P0DTO;
import com.rds.adams.web.biz.jnl.dto.BIZJNL003M0P1DTO;
import com.rds.adams.web.biz.jnl.dto.BIZJNL003M0R0DTO;

@Service
public class BIZJNL003M0Service {
	
	@Autowired
	BIZJNL003M0DAO bIZJNL003M0DAO;
	
	public List<BIZJNL003M0R0DTO> selectList(BIZJNL003M0P0DTO inVo) {
		
		return bIZJNL003M0DAO.selectList(inVo);
		
	}
	
	public void executeList(BIZJNL003M0P1DTO inVo) {
		bIZJNL003M0DAO.deleteList(inVo);
		bIZJNL003M0DAO.insertList(inVo);
	
		return;
	}
}
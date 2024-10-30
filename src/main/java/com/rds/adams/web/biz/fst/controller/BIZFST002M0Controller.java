package com.rds.adams.web.biz.fst.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.biz.fst.dto.BIZFST002M0P0DTO;
import com.rds.adams.web.biz.fst.dto.BIZFST002M0R0DTO;
import com.rds.adams.web.biz.fst.service.BIZFST002M0Service;
import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;
import com.rds.adams.web.core.utils.dto.ExecuteDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class BIZFST002M0Controller {
	
	@Autowired
	BIZFST002M0Service bIZFST002M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/BIZFST002M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<BIZFST002M0R0DTO> select(@RequestBody BIZFST002M0P0DTO inVo, HttpServletRequest request) {
		
		
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		inVo.setUsrId(sAdamsLoginDTO.getUsrId());
		inVo.setCsNo(sAdamsLoginDTO.getCsNo());
		
		log.info(inVo.toString());
		
		List<BIZFST002M0R0DTO> result = bIZFST002M0Service.selectList(inVo);
		
		for (BIZFST002M0R0DTO bIZFST002M0Service : result) {
				log.info(bIZFST002M0Service.toString());
		}
		
		return result;
	}
	
	@RequestMapping(value="/BIZFST002M0ExecuteList", method=RequestMethod.POST, consumes="application/json")
	public void execute(@RequestBody ExecuteDTO inVo, HttpServletRequest request) {
		
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		inVo.setStdYymm(inVo.getStdYymm());
		inVo.setUsrId(sAdamsLoginDTO.getUsrId());
		inVo.setCsNo(sAdamsLoginDTO.getCsNo());
		
		log.info(inVo.toString());
		try {
			bIZFST002M0Service.executeList(inVo);
			log.info("success");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}
}

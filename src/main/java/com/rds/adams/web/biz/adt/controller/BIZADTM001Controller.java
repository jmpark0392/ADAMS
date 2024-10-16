package com.rds.adams.web.biz.adt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.biz.adt.dto.BIZADT001M0P0DTO;
import com.rds.adams.web.biz.adt.dto.BIZADT001M0R0DTO;
import com.rds.adams.web.biz.adt.service.BIZADT001M0Service;
import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;
import com.rds.adams.web.core.utils.dto.ExecuteDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class BIZADTM001Controller {
	
	@Autowired
	BIZADT001M0Service bIZADT001M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/BIZADT001M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<BIZADT001M0R0DTO> select(@RequestBody BIZADT001M0P0DTO inVo, HttpServletRequest request) {
		
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		inVo.setCsNo(sAdamsLoginDTO.getCsNo());
		
		log.info(inVo.toString());
		
		List<BIZADT001M0R0DTO> result = bIZADT001M0Service.selectList(inVo);
		
		for (BIZADT001M0R0DTO bIZADT001M0Service : result) {
				log.info(bIZADT001M0Service.toString());
		}
		
		return result;
	}
	
	@RequestMapping(value="/BIZADT001M0ExecuteList", method=RequestMethod.POST, consumes="application/json")
	public void execute(@RequestBody ExecuteDTO inVo, HttpServletRequest request) {
		
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		inVo.setUsrId(sAdamsLoginDTO.getUsrId());
		inVo.setCsNo(sAdamsLoginDTO.getCsNo());
		
		log.info(inVo.toString());
		try {
			bIZADT001M0Service.executeList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}
}

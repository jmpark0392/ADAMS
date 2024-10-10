package com.rds.adams.web.biz.ins.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.biz.ins.dto.BIZINS003M0P0DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS003M0R0DTO;
import com.rds.adams.web.biz.ins.service.BIZINS003M0Service;
import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;
import com.rds.adams.web.core.utils.dto.ExecuteDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class BIZINS003M0Controller {
	
	@Autowired
	BIZINS003M0Service bIZINS003M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/BIZINS003M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<BIZINS003M0R0DTO> select(@RequestBody BIZINS003M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<BIZINS003M0R0DTO> result = bIZINS003M0Service.selectList(inVo);
		
		for (BIZINS003M0R0DTO bIZINS003M0Service : result) {
//				log.info(bIZINS00M0Service.toString());
		}
		
		return result;
		
	}
	
	@RequestMapping(value="/BIZINS003M0ExecuteList", method=RequestMethod.POST, consumes="application/json")
	public void execute(@RequestBody ExecuteDTO inVo, HttpServletRequest request) {
		
		ExecuteDTO executeDTO = new ExecuteDTO();
		executeDTO.setStdYymm(inVo.getStdYymm());
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		executeDTO.setUsrId(sAdamsLoginDTO.getUsrId());
		
		log.info(inVo.toString());
		try {
			bIZINS003M0Service.executeList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}
}

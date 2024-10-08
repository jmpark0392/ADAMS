package com.rds.adams.web.biz.ins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.biz.ins.dto.BIZINS001M0P0DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS001M0P1DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS001M0R0DTO;
import com.rds.adams.web.biz.ins.service.BIZINS001M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class BIZINS001M0Controller {
	
	@Autowired
	BIZINS001M0Service bIZINS001M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/BIZINS001M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<BIZINS001M0R0DTO> select(@RequestBody BIZINS001M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<BIZINS001M0R0DTO> result = bIZINS001M0Service.selectList(inVo);
		
		for (BIZINS001M0R0DTO bIZINS001M0Service : result) {
				log.info(bIZINS001M0Service.toString());
		}
		return result;	
	}
	
	@RequestMapping(value="/BIZINS001M0ExecuteList", method=RequestMethod.POST, consumes="application/json")
	public void execute(@RequestBody BIZINS001M0P1DTO inVo) {
		
		log.info(inVo.toString());
		try {
			bIZINS001M0Service.executeList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}
}
package com.rds.adams.web.biz.ins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.biz.ins.dto.BIZINS002M0P0DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS002M0P1DTO;
import com.rds.adams.web.biz.ins.dto.BIZINS002M0R0DTO;
import com.rds.adams.web.biz.ins.service.BIZINS002M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class BIZINS002M0Controller {
	
	@Autowired
	BIZINS002M0Service bIZINS002M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/BIZINS002M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<BIZINS002M0R0DTO> select(@RequestBody BIZINS002M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<BIZINS002M0R0DTO> result = bIZINS002M0Service.selectList(inVo);
		
		for (BIZINS002M0R0DTO bIZINS002M0Service : result) {
				log.info(bIZINS002M0Service.toString());
		}
		return result;
	}
	
	@RequestMapping(value="/BIZINS002M0ExecuteList", method=RequestMethod.POST, consumes="application/json")
	public void execute(@RequestBody BIZINS002M0P1DTO inVo) {
		
		log.info(inVo.toString());
		
		try {
			bIZINS002M0Service.executeList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}
}

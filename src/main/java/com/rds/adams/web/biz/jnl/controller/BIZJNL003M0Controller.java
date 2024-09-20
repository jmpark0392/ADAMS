package com.rds.adams.web.biz.jnl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.biz.jnl.dto.BIZJNL003M0P0DTO;
import com.rds.adams.web.biz.jnl.dto.BIZJNL003M0R0DTO;
import com.rds.adams.web.biz.jnl.service.BIZJNL003M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RequestMapping("/call")
@RestController
public class BIZJNL003M0Controller {
	
	@Autowired
	BIZJNL003M0Service bIZJNL003M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/BIZJNL003M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<BIZJNL003M0R0DTO> select(@RequestBody BIZJNL003M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<BIZJNL003M0R0DTO> result = bIZJNL003M0Service.selectList(inVo);
		
		for (BIZJNL003M0R0DTO bIZJNL003M0Service : result) {
				log.info(bIZJNL003M0Service.toString());
		}
		
		return result;
		
	}
}

package com.rds.adams.web.biz.jnl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.biz.jnl.dto.BIZJNL002M0P0DTO;
import com.rds.adams.web.biz.jnl.dto.BIZJNL002M0P1DTO;
import com.rds.adams.web.biz.jnl.dto.BIZJNL002M0R0DTO;
import com.rds.adams.web.biz.jnl.service.BIZJNL002M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class BIZJNL002M0Controller {
	
	@Autowired
	BIZJNL002M0Service bIZJNL002M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/BIZJNL002M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<BIZJNL002M0R0DTO> select(@RequestBody BIZJNL002M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<BIZJNL002M0R0DTO> result = bIZJNL002M0Service.selectList(inVo);
		
		for (BIZJNL002M0R0DTO bIZJNL002M0Service : result) {
				log.info(bIZJNL002M0Service.toString());
		}
		
		return result;
		
	}
	
	@RequestMapping(value="/BIZJNL002M0InsertList", method=RequestMethod.POST, consumes="application/json")
	public void insert(@RequestBody BIZJNL002M0P1DTO inVo) {
		
		log.info(inVo.toString());
		try {
			bIZJNL002M0Service.insertList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}

	@RequestMapping(value="/BIZJNL002M0UpdateList", method=RequestMethod.POST, consumes="application/json")
	public void update(@RequestBody BIZJNL002M0P1DTO inVo) {
		
		log.info(inVo.toString());
		try {
			bIZJNL002M0Service.updateList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}
	
	@RequestMapping(value="/BIZJNL002M0DeleteList", method=RequestMethod.POST, consumes="application/json")
	public void delete(@RequestBody BIZJNL002M0P1DTO inVo) {
		
		log.info(inVo.toString());
		try {
			bIZJNL002M0Service.deleteList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		
	}
}
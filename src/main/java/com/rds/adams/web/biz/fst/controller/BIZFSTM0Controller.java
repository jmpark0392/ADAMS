package com.rds.adams.web.biz.fst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.biz.fst.dto.BIZFST001M0P0DTO;
import com.rds.adams.web.biz.fst.dto.BIZFST001M0R0DTO;
import com.rds.adams.web.biz.fst.service.BIZFST001M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class BIZFSTM0Controller {
	
	@Autowired
	BIZFST001M0Service bIZFST001M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/BIZFST001M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<BIZFST001M0R0DTO> select(@RequestBody BIZFST001M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<BIZFST001M0R0DTO> result = bIZFST001M0Service.selectList(inVo);
		
		for (BIZFST001M0R0DTO bIZFST001M0Service : result) {
				log.info(bIZFST001M0Service.toString());
		}
		
		return result;
		
	}
}
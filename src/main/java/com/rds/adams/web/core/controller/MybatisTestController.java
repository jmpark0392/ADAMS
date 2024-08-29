package com.rds.adams.web.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.core.dto.GocInfoDto;
import com.rds.adams.web.core.service.MybatisTestService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class MybatisTestController {
	
	@Autowired
	MybatisTestService mybatisTestService; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/MybatisTestSelectList", method=RequestMethod.POST, consumes="application/json")
	public List<GocInfoDto> select(@RequestBody GocInfoDto inVo) {
		
		log.info(inVo.toString());
		
		List<GocInfoDto> result = mybatisTestService.selectList(inVo);
		
		for (GocInfoDto gocInfoVo : result) {
				log.info(gocInfoVo.toString());
		}
		
		return result;
		
	}

}

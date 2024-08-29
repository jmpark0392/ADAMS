package com.rds.adams.web.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.core.dto.SearchTxtDto;
import com.rds.adams.web.core.dto.UplFileDto;
import com.rds.adams.web.core.service.FileMntService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class FileMntController {
	
	@Autowired
	FileMntService fileMntservice; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/FileMntSelectList", method=RequestMethod.POST, consumes="application/json")
	public List<UplFileDto> select(@RequestBody SearchTxtDto inVo) {
		
		log.info(inVo.toString());
		
		List<UplFileDto> result = fileMntservice.selectList(inVo);
		
		for (UplFileDto uplFileVo : result) {
				log.info(uplFileVo.toString());
		}
		
		return result;
		
	}

}

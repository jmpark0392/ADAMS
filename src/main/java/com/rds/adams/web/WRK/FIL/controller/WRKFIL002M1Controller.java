package com.rds.adams.web.WRK.FIL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M1P0DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M1R0DTO;
import com.rds.adams.web.WRK.FIL.service.WRKFIL002M1Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class WRKFIL002M1Controller {
	
	@Autowired
	WRKFIL002M1Service wRKFIL002M1Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/WRKFIL002M1SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<WRKFIL002M1R0DTO> select(@RequestBody WRKFIL002M1P0DTO inVo) {
		
		log.info(inVo.toString());

		List<WRKFIL002M1R0DTO> result = wRKFIL002M1Service.selectList(inVo);

		for (WRKFIL002M1R0DTO wRKFIL002M1R0DTO : result) {
				log.info(wRKFIL002M1R0DTO.toString());
		}

		return result;
		
	}

}
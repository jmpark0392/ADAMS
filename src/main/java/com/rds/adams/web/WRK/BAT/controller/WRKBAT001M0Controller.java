package com.rds.adams.web.WRK.BAT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.WRK.BAT.dto.WRKBAT001M0P0DTO;
import com.rds.adams.web.WRK.BAT.dto.WRKBAT001M0P1DTO;
import com.rds.adams.web.WRK.BAT.dto.WRKBAT001M0R0DTO;
import com.rds.adams.web.WRK.BAT.service.WRKBAT001M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class WRKBAT001M0Controller {
	
	@Autowired
	WRKBAT001M0Service wRKBAT001M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/WRKBAT001M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<WRKBAT001M0R0DTO> select(@RequestBody WRKBAT001M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<WRKBAT001M0R0DTO> result = wRKBAT001M0Service.selectList(inVo);
		
		for (WRKBAT001M0R0DTO wRKBAT001M0R0DTO : result) {
				log.info(wRKBAT001M0R0DTO.toString());
		}
		
		return result;
		
	}
	
	@RequestMapping(value="/WRKBAT001M0InsertList", method=RequestMethod.POST, consumes="application/json")
	public void insert(@RequestBody WRKBAT001M0P1DTO inVo) {
		
		log.info(inVo.toString());
		try {
			wRKBAT001M0Service.insertList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}

	@RequestMapping(value="/WRKBAT001M0UpdateList", method=RequestMethod.POST, consumes="application/json")
	public void update(@RequestBody WRKBAT001M0P1DTO inVo) {
		
		log.info(inVo.toString());
		try {
			wRKBAT001M0Service.updateList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}
	
	@RequestMapping(value="/WRKBAT001M0DeleteList", method=RequestMethod.POST, consumes="application/json")
	public void delete(@RequestBody WRKBAT001M0P1DTO inVo) {
		
		log.info(inVo.toString());
		try {
			wRKBAT001M0Service.deleteList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		
	}
}

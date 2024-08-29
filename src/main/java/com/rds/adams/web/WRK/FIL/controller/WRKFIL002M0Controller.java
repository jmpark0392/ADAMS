package com.rds.adams.web.WRK.FIL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M0P0DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M0P1DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M0P2DTO;
import com.rds.adams.web.WRK.FIL.dto.WRKFIL002M0R0DTO;
import com.rds.adams.web.WRK.FIL.service.WRKFIL002M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class WRKFIL002M0Controller {
	
	@Autowired
	WRKFIL002M0Service wRKFIL002M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/WRKFIL002M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<WRKFIL002M0R0DTO> select(@RequestBody WRKFIL002M0P0DTO inVo) {
		
		log.info(inVo.toString());

		List<WRKFIL002M0R0DTO> result = wRKFIL002M0Service.selectList(inVo);

		for (WRKFIL002M0R0DTO wRKFIL002M0R0DTO : result) {
				log.info(wRKFIL002M0R0DTO.toString());
		}

		return result;
		
	}
	
	@RequestMapping(value="/WRKFIL002M0InsertList", method=RequestMethod.POST, consumes="application/json")
	public void insert(@RequestBody WRKFIL002M0P1DTO inVo) {
		
		log.info(inVo.toString());
		try {
			wRKFIL002M0Service.insertList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}

	@RequestMapping(value="/WRKFIL002M0UpdateList", method=RequestMethod.POST, consumes="application/json")
	public void update(@RequestBody WRKFIL002M0P1DTO inVo) {
		
		log.info(inVo.toString());
		try {
			wRKFIL002M0Service.updateList(inVo);
			log.info("success");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("fail");
		}
		return;
	}
	
	@RequestMapping(value="/WRKFIL002M0DeleteList", method=RequestMethod.POST, consumes="application/json")
	public void delete(@RequestBody WRKFIL002M0P2DTO inVo) {
	    
	    log.info(inVo.toString());
	    try {
	        wRKFIL002M0Service.deleteList(inVo);
	        log.info("success");
	    } catch (Exception e) {
	        e.printStackTrace();
	        log.info("fail");
	    }
	    return;
	}
}

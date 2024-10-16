package com.rds.adams.web.wrk.bat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;
import com.rds.adams.web.wrk.bat.dto.WRKBAT002M0P0DTO;
import com.rds.adams.web.wrk.bat.dto.WRKBAT002M0R0DTO;
import com.rds.adams.web.wrk.bat.service.WRKBAT002M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class WRKBAT002M0Controller {
	
	@Autowired
	WRKBAT002M0Service wRKBAT002M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/WRKBAT002M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<WRKBAT002M0R0DTO> select(@RequestBody WRKBAT002M0P0DTO inVo, HttpServletRequest request) {
		
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		inVo.setCsNo(sAdamsLoginDTO.getCsNo());
		
		log.info(inVo.toString());
		
		List<WRKBAT002M0R0DTO> result = wRKBAT002M0Service.selectList(inVo);
		
		for (WRKBAT002M0R0DTO wRKBAT002M0R0DTO : result) {
				log.info(wRKBAT002M0R0DTO.toString());
		}
		
		return result;
	}
}

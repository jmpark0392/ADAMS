package com.rds.adams.web.wrk.fil.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;
import com.rds.adams.web.wrk.fil.dto.WRKFIL001M0P0DTO;
import com.rds.adams.web.wrk.fil.dto.WRKFIL001M0P1DTO;
import com.rds.adams.web.wrk.fil.dto.WRKFIL001M0R0DTO;
import com.rds.adams.web.wrk.fil.service.WRKFIL001M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
public class WRKFIL001M0Controller {
	
	@Autowired
	WRKFIL001M0Service wRKFIL001M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/WRKFIL001M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<WRKFIL001M0R0DTO> select(@RequestBody WRKFIL001M0P0DTO inVo, HttpServletRequest request) {
		
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		inVo.setCsNo(sAdamsLoginDTO.getCsNo());
		inVo.setUsrNm(sAdamsLoginDTO.getUsrNm());
		
		log.info(inVo.toString());
		
		List<WRKFIL001M0R0DTO> result = wRKFIL001M0Service.selectList(inVo);
		
		for (WRKFIL001M0R0DTO wRKFIL001M0R0DTO : result) {
				log.info(wRKFIL001M0R0DTO.toString());
		}
		
		return result;
		
	}
	
	@RequestMapping(value="/WRKFIL001M0InsertList", method=RequestMethod.POST, consumes="application/json")
	public HashMap<String, Object> insert(@RequestBody WRKFIL001M0P1DTO inVo, HttpServletRequest request) {
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		inVo.setFrstRegEmpNo(sAdamsLoginDTO.getUsrId());
		inVo.setCsNo(sAdamsLoginDTO.getCsNo());
		
		log.info(inVo.toString());
		try {
			wRKFIL001M0Service.insertList(inVo);

			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "Success !!!");
		} catch (Exception e) {
			resultMap.put("resultCode"   , "300");
			resultMap.put("resultMessage", e.getMessage());
		}
		return resultMap;
	}

	@RequestMapping(value="/WRKFIL001M0UpdateList", method=RequestMethod.POST, consumes="application/json")
	public HashMap<String, Object> update(@RequestBody WRKFIL001M0P1DTO inVo, HttpServletRequest request) {
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		inVo.setFrstRegEmpNo(sAdamsLoginDTO.getUsrId());
		inVo.setCsNo(sAdamsLoginDTO.getCsNo());
		
		log.info(inVo.toString());
		try {
			wRKFIL001M0Service.updateList(inVo);
			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "Success !!!");
		} catch (Exception e) {
			resultMap.put("resultCode"   , "300");
			resultMap.put("resultMessage", e.getMessage());
		}
		return resultMap;
	}
	
	@RequestMapping(value="/WRKFIL001M0DeleteList", method=RequestMethod.POST, consumes="application/json")
	public HashMap<String, Object> delete(@RequestBody WRKFIL001M0P1DTO inVo, HttpServletRequest request) {
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
		inVo.setCsNo(sAdamsLoginDTO.getCsNo());		
		
		log.info(inVo.toString());
		try {
			wRKFIL001M0Service.deleteList(inVo);
			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "Success !!!");
		} catch (Exception e) {
			resultMap.put("resultCode"   , "300");
			resultMap.put("resultMessage", e.getMessage());
		}
		return resultMap;
	}
}

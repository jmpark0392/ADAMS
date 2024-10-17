package com.rds.adams.web.opn.srv.controller;

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
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0P0DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0P1DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0R0DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0R1DTO;
import com.rds.adams.web.opn.srv.service.OPNSRV001M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 10. 16.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-10-16 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */

@Slf4j
@RestController
public class OPNSRV001M0Controller {
	
	@Autowired
	OPNSRV001M0Service OPNSRV001M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/OPNSRV001M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<OPNSRV001M0R0DTO> selectCsNoList(@RequestBody OPNSRV001M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<OPNSRV001M0R0DTO> result = OPNSRV001M0Service.selectSrvcList(inVo);
		
		log.info(result.toString());
		
		return result;
		
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/OPNSRV001M0SelectHistList", method=RequestMethod.POST, consumes="application/json")
	public List<OPNSRV001M0R1DTO> selectCsNoList(@RequestBody OPNSRV001M0P1DTO inVo) {
		
		log.info(inVo.toString());
		
		List<OPNSRV001M0R1DTO> result = OPNSRV001M0Service.selectSrvcHistList(inVo);
		
		log.info(result.toString());
		
		return result;
		
	}
	
	/**
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/OPNSRV001M0UpdateList", method=RequestMethod.POST, consumes="application/json")
	public HashMap<String, Object> saveCsNo(@RequestBody OPNSRV001M0R0DTO inVo, HttpServletRequest request) throws Exception {
		
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
	    boolean  bResult = false;
		
		log.info(inVo.toString());

    	AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
    	inVo.setUsrId(sAdamsLoginDTO.getUsrId());
		
		bResult = OPNSRV001M0Service.saveCsNo(inVo);
		
		if (bResult) {
			
			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "Success !!!");
		} else {
			resultMap.put("resultCode"   , "300");
			resultMap.put("resultMessage", "Save Failed !!!");
		}
		
		return resultMap;
		
	}

	
}
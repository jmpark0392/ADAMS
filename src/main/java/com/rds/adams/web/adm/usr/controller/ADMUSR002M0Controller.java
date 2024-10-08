package com.rds.adams.web.adm.usr.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.adm.usr.dto.ADMUSR002M0P0DTO;
import com.rds.adams.web.adm.usr.dto.ADMUSR002M0R0DTO;
import com.rds.adams.web.adm.usr.service.ADMUSR002M0Service;
import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 10. 07.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-10-07 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */

@Slf4j
@RestController
public class ADMUSR002M0Controller {
	
	@Autowired
	ADMUSR002M0Service aDMUSR002M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/ADMUSR002M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<ADMUSR002M0R0DTO> selectUsrList(@RequestBody ADMUSR002M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<ADMUSR002M0R0DTO> result = aDMUSR002M0Service.selectUsrList(inVo);
		
		log.info(result.toString());
		
		return result;
		
	}
	
	/**
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/ADMUSR002M0UpdateList", method=RequestMethod.POST, consumes="application/json")
	public HashMap<String, Object> saveUsr(@RequestBody ADMUSR002M0R0DTO inVo, HttpServletRequest request) throws Exception {
		
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
	    boolean  bResult = false;
		
		log.info(inVo.toString());

    	AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
    	inVo.setUpdId(sAdamsLoginDTO.getUsrId());
		
		bResult = aDMUSR002M0Service.saveUsr(inVo);
		
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

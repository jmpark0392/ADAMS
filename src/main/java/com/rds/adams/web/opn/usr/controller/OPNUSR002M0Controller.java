package com.rds.adams.web.opn.usr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.opn.usr.dto.OPNUSR002M0P0DTO;
import com.rds.adams.web.opn.usr.dto.OPNUSR002M0R0DTO;
import com.rds.adams.web.opn.usr.service.OPNUSR002M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 9. 26.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-09-26 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */

@Slf4j
@RestController
public class OPNUSR002M0Controller {
	
	@Autowired
	OPNUSR002M0Service oPNUSR002M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/OPNUSR002M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public List<OPNUSR002M0R0DTO> selectCsNoList(@RequestBody OPNUSR002M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		List<OPNUSR002M0R0DTO> result = oPNUSR002M0Service.selectCsNoList(inVo);
		
		log.info(result.toString());
		
		return result;
		
	}

	
}

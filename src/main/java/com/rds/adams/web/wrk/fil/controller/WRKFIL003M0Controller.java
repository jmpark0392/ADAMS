package com.rds.adams.web.wrk.fil.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rds.adams.web.wrk.fil.dto.WRKFIL003M0P0DTO;
import com.rds.adams.web.wrk.fil.dto.WRKFIL003M0R1DTO;
import com.rds.adams.web.wrk.fil.service.WRKFIL003M0Service;

import lombok.extern.slf4j.Slf4j;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 6. 11.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-06-11 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */

@Slf4j
@RestController
public class WRKFIL003M0Controller {
	
	@Autowired
	WRKFIL003M0Service wRKFIL003M0Service; 
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/WRKFIL003M0SelectList", method=RequestMethod.POST, consumes="application/json")
	public HashMap<String, Object> select(@RequestBody WRKFIL003M0P0DTO inVo) {
		
		log.info(inVo.toString());
		
		HashMap<String, Object> result = wRKFIL003M0Service.selectList(inVo);
		
		log.info(result.toString());
		
		return result;
		
	}

	/**
	 * @param model
	 * @return
	 */
	@SuppressWarnings("resource")
	@RequestMapping(value="/WRKFIL003M0SaveUploadFile", method=RequestMethod.POST)
	public String saveUploadFile( @RequestPart(name = "uploadFile") MultipartFile[] uploadFile, @RequestPart(name = "param") WRKFIL003M0P0DTO inVo) throws Exception {
		
		log.info(uploadFile.toString() + "\n" + inVo.toString());
		
		wRKFIL003M0Service.saveUploadFile(uploadFile, inVo);
		
		log.info("");
		
		return "";
    }
	
	/**
	 * @param model
	 * @return
	 */
	@SuppressWarnings("resource")
	@RequestMapping(value="/WRKFIL003M0SelectFileList", method=RequestMethod.POST)
	public List<WRKFIL003M0R1DTO> selectFileList( WRKFIL003M0P0DTO inVo) throws Exception {
		
		log.info(inVo.toString());
		
		List<WRKFIL003M0R1DTO> result = wRKFIL003M0Service.selectFileList(inVo);
		
		log.info("");
		
		return result;
    }
	
}

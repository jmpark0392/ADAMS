package com.rds.adams.web.opn.srv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.opn.srv.dao.OPNSRV001M0DAO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0P0DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0P1DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0R0DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0R1DTO;

import lombok.RequiredArgsConstructor;
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
@Service
@RequiredArgsConstructor
public class OPNSRV001M0Service {

	@Autowired
	private OPNSRV001M0DAO OPNSRV001M0DAO;

	/**
	 * 서비스 정보 조회를 처리한다
	 * @param vo OPNSRV001M0P0DTO
	 * @return List<OPNSRV001M0R0DTO>
	 * @exception Exception
	 */
	public List<OPNSRV001M0R0DTO> selectSrvcList(OPNSRV001M0P0DTO inVo) {
		
		List<OPNSRV001M0R0DTO>	OPNSRV001M0P0DTOList = OPNSRV001M0DAO.selectSrvcList(inVo);	// 조회 대상 테이블 정보 DTO
		
		log.debug(" OPNSRV001M0P0DTOList : " + OPNSRV001M0P0DTOList.toString());
		
		return OPNSRV001M0P0DTOList;
		
	}

	/**
	 * 서비스 이력 정보 조회를 처리한다
	 * @param vo OPNSRV001M0P1DTO
	 * @return List<OPNSRV001M0R1DTO>
	 * @exception Exception
	 */
	public List<OPNSRV001M0R1DTO> selectSrvcHistList(OPNSRV001M0P1DTO inVo) {
		
		List<OPNSRV001M0R1DTO>	OPNSRV001M0R1DTOList = OPNSRV001M0DAO.selectSrvcHistList(inVo);	// 조회 대상 테이블 정보 DTO
		
		log.debug(" OPNSRV001M0R1DTOList : " + OPNSRV001M0R1DTOList.toString());
		
		return OPNSRV001M0R1DTOList;
		
	}

	/**
	 * 고객사 정보 저장을 처리한다
	 * @param vo OPNSRV001M0R0DTO
	 * @return boolean
	 * @exception Exception
	 */
	public boolean saveCsNo(OPNSRV001M0R0DTO inVo) throws Exception {
		
		OPNSRV001M0DAO.updateCsNo(inVo);	// 조회 대상 테이블 정보 DTO
		
		
		log.debug(" OPNSRV001M0R0DTO : " + inVo.toString());
		
		return true;
		
	}
	

}
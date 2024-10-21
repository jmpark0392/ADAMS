package com.rds.adams.web.opn.srv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.opn.srv.dao.OPNSRV002M0DAO;
import com.rds.adams.web.opn.srv.dto.OPNSRV002M0P0DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV002M0P1DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV002M0R0DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV002M0R1DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV002M0R2DTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 10. 21.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-10-21 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class OPNSRV002M0Service {

	@Autowired
	private OPNSRV002M0DAO oPNSRV002M0DAO;

	/**
	 * 옵션 정보 조회를 처리한다
	 * @param vo OPNSRV002M0P0DTO
	 * @return List<OPNSRV002M0R0DTO>
	 * @exception Exception
	 */
	public List<OPNSRV002M0R0DTO> selectOptList(OPNSRV002M0P0DTO inVo) {
		
		List<OPNSRV002M0R0DTO>	oPNSRV002M0P0DTOList = oPNSRV002M0DAO.selectOptList(inVo);	// 조회 대상 테이블 정보 DTO
		
		log.debug(" OPNSRV002M0P0DTOList : " + oPNSRV002M0P0DTOList.toString());
		
		return oPNSRV002M0P0DTOList;
		
	}

	/**
	 * 옵션 이력 정보 조회를 처리한다
	 * @param vo OPNSRV002M0P1DTO
	 * @return List<OPNSRV002M0R1DTO>
	 * @exception Exception
	 */
	public List<OPNSRV002M0R1DTO> selectOptHistList(OPNSRV002M0P1DTO inVo) {
		
		List<OPNSRV002M0R1DTO>	oPNSRV002M0R1DTOList = oPNSRV002M0DAO.selectOptHistList(inVo);	// 조회 대상 테이블 정보 DTO
		
		log.debug(" OPNSRV002M0R1DTOList : " + oPNSRV002M0R1DTOList.toString());
		
		return oPNSRV002M0R1DTOList;
		
	}

	/**
	 * 옵션 이력 정보 조회를 처리한다
	 * @param vo OPNSRV002M0P1DTO
	 * @return List<OPNSRV002M0R2DTO>
	 * @exception Exception
	 */
	public List<OPNSRV002M0R2DTO> selectOptDetailList(OPNSRV002M0P1DTO inVo) {
		
		List<OPNSRV002M0R2DTO>	oPNSRV002M0R2DTOList = oPNSRV002M0DAO.selectOptDetailList(inVo);	// 조회 대상 테이블 정보 DTO
		
		log.debug(" OPNSRV002M0R2DTOList : " + oPNSRV002M0R2DTOList.toString());
		
		return oPNSRV002M0R2DTOList;
		
	}

	/**
	 * 옵션 정보 저장을 처리한다
	 * @param vo OPNSRV002M0R0DTO
	 * @return boolean
	 * @exception Exception
	 */
	public boolean updateOptList(OPNSRV002M0R0DTO inVo) throws Exception {
		
		String sChkDate = "";
		String sChkCd   = "";
		
		try {
			
			sChkDate = oPNSRV002M0DAO.selectChkDate(inVo);
			
			if ( "1".equals(sChkDate) ) {
				// Error : "현재 날짜보다 과거를 시작할 수 없습니다."
				throw new Exception("OPNSRV002M0Service Error : You can't start the past more than the current date.");
			}
			
			sChkCd = oPNSRV002M0DAO.selectChkHist(inVo);
			
			oPNSRV002M0DAO.updateOpt(inVo);
			
			if ( "1".equals(sChkCd) ) {
				oPNSRV002M0DAO.updateOptHistDay(inVo);	// Hist 시작일자 기준 Update
			} else {
				
				
				oPNSRV002M0DAO.updateOptHistBefor(inVo);
				
				oPNSRV002M0DAO.insertOptHist(inVo);
				
			}
		} catch (Exception e) {
			throw new Exception("OPNSRV002M0Service Error : " + e.getMessage());
		}
		log.debug(" OPNSRV002M0R0DTO : " + inVo.toString());
		
		return true;
		
	}

	/**
	 * 옵션 정보 저장을 처리한다
	 * @param vo OPNSRV002M0R0DTO
	 * @return boolean
	 * @exception Exception
	 */
	public boolean insertOptList(OPNSRV002M0R0DTO inVo) throws Exception {
		
		String sChkDate = "";
		
		try {
			
			sChkDate = oPNSRV002M0DAO.selectChkDate(inVo);
			
			if ( "1".equals(sChkDate) ) {
				// Error : "현재 날짜보다 과거를 시작할 수 없습니다."
				throw new Exception("OPNSRV002M0Service Error : You can't start the past more than the current date.");
			}
			
			oPNSRV002M0DAO.insertOpt(inVo);
			
			oPNSRV002M0DAO.insertOptHist(inVo);
			
		} catch (Exception e) {
			throw new Exception("OPNSRV002M0Service Error : " + e.getMessage());
		}
		log.debug(" OPNSRV002M0R0DTO : " + inVo.toString());
		
		return true;
		
	}
	

}
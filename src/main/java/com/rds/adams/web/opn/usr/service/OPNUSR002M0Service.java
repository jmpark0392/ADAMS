package com.rds.adams.web.opn.usr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.adams.web.opn.usr.dao.OPNUSR002M0DAO;
import com.rds.adams.web.opn.usr.dto.OPNUSR002M0P0DTO;
import com.rds.adams.web.opn.usr.dto.OPNUSR002M0R0DTO;

import lombok.RequiredArgsConstructor;
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
@Service
@RequiredArgsConstructor
public class OPNUSR002M0Service {

	@Autowired
	private OPNUSR002M0DAO oPNUSR002M0DAO;

	/**
	 * 일반 로그인을 처리한다
	 * @param vo OPNUSR002M0P0DTO
	 * @return List<OPNUSR002M0R0DTO>
	 * @exception Exception
	 */
	public List<OPNUSR002M0R0DTO> selectCsNoList(OPNUSR002M0P0DTO inVo) {
		
		List<OPNUSR002M0R0DTO>	oPNUSR002M0P0DTOList = oPNUSR002M0DAO.selectCsNoList(inVo);	// 조회 대상 테이블 정보 DTO
		
		log.debug(" oPNUSR002M0P0DTOList : " + oPNUSR002M0P0DTOList.toString());
		
		return oPNUSR002M0P0DTOList;
		
	}
	

}
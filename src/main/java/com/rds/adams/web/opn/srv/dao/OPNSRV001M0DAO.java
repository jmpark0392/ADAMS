package com.rds.adams.web.opn.srv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.opn.srv.dto.OPNSRV001M0P0DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0P1DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0R0DTO;
import com.rds.adams.web.opn.srv.dto.OPNSRV001M0R1DTO;

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

@Mapper
public interface OPNSRV001M0DAO {

	/**
	 * 서비스 목록 조회를 처리한다
	 * @param vo OPNSRV001M0P0DTO
	 * @return List<OPNSRV001M0R0DTO>
	 * @exception Exception
	 */
	public List<OPNSRV001M0R0DTO> selectSrvcList(OPNSRV001M0P0DTO inVo);

	/**
	 * 서비스 이력 목록 조회를 처리한다
	 * @param vo OPNSRV001M0P0DTO
	 * @return List<OPNSRV001M0R0DTO>
	 * @exception Exception
	 */
	public List<OPNSRV001M0R1DTO> selectSrvcHistList(OPNSRV001M0P1DTO inVo);

	/**
	 * 서비스 정보를 저장한다
	 * @param vo OPNSRV001M0P1DTO
	 * @exception Exception
	 */
	public void updateCsNo(OPNSRV001M0R0DTO inVo);

	/**
	 * 서비스 이력 정보를 저장한다
	 * @param vo OPNSRV001M0P1DTO
	 * @exception Exception
	 */
	public void insertAdmUsr(OPNSRV001M0R0DTO inVo);

}
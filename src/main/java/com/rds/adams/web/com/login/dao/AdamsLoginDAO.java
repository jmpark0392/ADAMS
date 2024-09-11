package com.rds.adams.web.com.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rds.adams.web.com.login.dto.AdamsCsNoDTO;
import com.rds.adams.web.com.login.dto.AdamsLoginDTO;
import com.rds.adams.web.com.login.dto.AdamsMenuDTO;

/**
 * 일반 로그인을 처리하는 비즈니스 구현 클래스
 * @author 공통서비스 개발팀 박지욱
 * @since 2009.03.06
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.06  박지욱          최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *  </pre>
 */
@Mapper
public interface AdamsLoginDAO {

	/**
	 * 일반 로그인을 처리한다
	 * @param vo AdamsLoginDAO
	 * @return AdamsLoginDAO
	 * @exception Exception
	 */
	public AdamsLoginDTO actionLogin(AdamsLoginDTO vo) ;

	/**
	 * 사용자 메뉴를 처리한다
	 * @param vo AdamsLoginDAO
	 * @return List<AdamsMenuDTO>
	 * @exception Exception
	 */
	public List<AdamsMenuDTO> actionMenu(AdamsLoginDTO vo) ;

	/**
	 * 고객사 목록 조회 한다
	 * @param vo AdamsLoginDAO
	 * @return List<AdamsCsNoDTO>
	 * @exception Exception
	 */
	public List<AdamsCsNoDTO> selectCsNoList(AdamsLoginDTO vo) ;

	/**
	 * 아이디를 찾는다.
	 * @param vo AdamsLoginDAO
	 * @return AdamsLoginDAO
	 * @exception Exception
	 */
	public AdamsLoginDTO searchId(AdamsLoginDTO vo);

	/**
	 * 비밀번호를 찾는다.
	 * @param vo AdamsLoginDAO
	 * @return AdamsLoginDAO
	 * @exception Exception
	 */
	public AdamsLoginDTO searchPassword(AdamsLoginDTO vo);

	/**
	 * 변경된 비밀번호를 저장한다.
	 * @param vo AdamsLoginDAO
	 * @exception Exception
	 */
	public void updatePassword(AdamsLoginDTO vo) ;
}

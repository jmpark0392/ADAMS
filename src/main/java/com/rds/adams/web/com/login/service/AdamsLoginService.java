package com.rds.adams.web.com.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rds.adams.web.com.login.dao.AdamsLoginDAO;
import com.rds.adams.web.com.login.dto.AdamsLoginDTO;
import com.rds.adams.web.com.login.dto.AdamsMenuDTO;

import egovframework.let.utl.fcc.service.EgovNumberUtil;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.let.utl.sim.service.EgovFileScrty;
import lombok.RequiredArgsConstructor;

/**
 * 일반 로그인을 처리하는 비즈니스 구현 클래스
 * @author 공통서비스 개발팀 박지욱
 * @since 2024.09.05
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2024.09.05  LCG          최초 생성
 *
 *  </pre>
 */
@Service
@RequiredArgsConstructor
public class AdamsLoginService {

	@Resource(name = "adamsLoginDAO")
	private AdamsLoginDAO adamsLoginDAO;

	/**
	 * 일반 로그인을 처리한다
	 * @param vo AdamsLoginDTO
	 * @return AdamsLoginDTO
	 * @exception Exception
	 */
	public AdamsLoginDTO selectLoginInfo(AdamsLoginDTO vo) throws Exception {

		// 1. 입력한 비밀번호를 암호화한다.
		//생략 DB에서 진행
		
		// 2. 아이디와 비밀번호가 DB와 일치하는지 확인한다.
		AdamsLoginDTO adamsLoginDTO = adamsLoginDAO.actionLogin(vo);

		// 3. 결과를 리턴한다.
		if (adamsLoginDTO != null && !adamsLoginDTO.getUsrId().equals("") && !adamsLoginDTO.getUsrPassword().equals("")) {
			return adamsLoginDTO;
		} else {
			adamsLoginDTO = new AdamsLoginDTO();
		}

		return adamsLoginDTO;
	}

	/**
	 * 사용자 메뉴를 처리한다
	 * @param vo AdamsLoginDTO
	 * @return List<AdamsMenuDTO>
	 * @exception Exception
	 */
	public List<AdamsMenuDTO> selectMenuList(AdamsLoginDTO vo) throws Exception {

		// 1. 사용자 메뉴 옥록을 확인한다.
		List<AdamsMenuDTO> adamsLoginDTOs = adamsLoginDAO.actionMenu(vo);

		// 2. 결과를 리턴한다.
		if (adamsLoginDTOs != null && adamsLoginDTOs.size() != 0 && !adamsLoginDTOs.get(0).getMenuId().equals("")) {
			return adamsLoginDTOs;
		} else {
			adamsLoginDTOs = new ArrayList<>();
		}

		return adamsLoginDTOs;
	}

	/**
	 * 아이디를 찾는다.
	 * @param vo AdamsLoginDTO
	 * @return AdamsLoginDTO
	 * @exception Exception
	 */
	public AdamsLoginDTO searchId(AdamsLoginDTO vo) throws Exception {

		// 1. 이름, 이메일주소가 DB와 일치하는 사용자 ID를 조회한다.
		AdamsLoginDTO adamsLoginDTO = adamsLoginDAO.searchId(vo);

		// 2. 결과를 리턴한다.
		if (adamsLoginDTO != null && !adamsLoginDTO.getUsrId().equals("")) {
			return adamsLoginDTO;
		} else {
			adamsLoginDTO = new AdamsLoginDTO();
		}

		return adamsLoginDTO;
	}

	/**
	 * 비밀번호를 찾는다.
	 * @param vo AdamsLoginDTO
	 * @return boolean
	 * @exception Exception
	 */
	public boolean searchPassword(AdamsLoginDTO vo) throws Exception {

		boolean result = true;

		// 1. 아이디, 이름, 이메일주소, 비밀번호 힌트, 비밀번호 정답이 DB와 일치하는 사용자 Password를 조회한다.
		AdamsLoginDTO adamsLoginDTO = adamsLoginDAO.searchPassword(vo);
		if (adamsLoginDTO == null || adamsLoginDTO.getUsrPassword() == null || adamsLoginDTO.getUsrPassword().equals("")) {
			return false;
		}

		// 2. 임시 비밀번호를 생성한다.(영+영+숫+영+영+숫=6자리)
		String newpassword = "";
		for (int i = 1; i <= 6; i++) {
			// 영자
			if (i % 3 != 0) {
				newpassword += EgovStringUtil.getRandomStr('a', 'z');
				// 숫자
			} else {
				newpassword += EgovNumberUtil.getRandomNum(0, 9);
			}
		}

		// 3. 임시 비밀번호를 암호화하여 DB에 저장한다.
		AdamsLoginDTO pwVO = new AdamsLoginDTO();
		String enpassword = EgovFileScrty.encryptPassword(newpassword, vo.getUsrId());
		pwVO.setUsrId(vo.getUsrId());
		pwVO.setUsrPassword(enpassword);
		pwVO.setUsrDvCd(vo.getUsrDvCd());
		adamsLoginDAO.updatePassword(pwVO);

		return result;
	}
}
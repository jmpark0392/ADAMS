package com.rds.adams.web.common.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.rds.adams.web.common.login.dao.AdamsLoginDAO;
import com.rds.adams.web.common.login.dto.AdamsCsNoDTO;
import com.rds.adams.web.common.login.dto.AdamsFindPwDTO;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;
import com.rds.adams.web.common.login.dto.AdamsMenuDTO;
import com.rds.adams.web.core.utils.EmailUtil;
import com.rds.adams.web.core.utils.dto.EmailDTO;

import egovframework.let.utl.fcc.service.EgovNumberUtil;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
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
		
		log.debug(" =====================> AdamsLoginDTO : " + vo.toString() );
		// 1. 입력한 비밀번호를 암호화한다.
		//생략 DB에서 진행
		
		// 2. 아이디와 비밀번호가 DB와 일치하는지 확인한다.
		AdamsLoginDTO adamsLoginDTO = adamsLoginDAO.actionLogin(vo);

		// 3. 결과를 리턴한다.
		if (adamsLoginDTO != null && !adamsLoginDTO.getUsrId().equals("") && !adamsLoginDTO.getUsrDvCd().equals("")) {
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
	 * 사용자 메뉴를 Tree 구조 처리한다
	 * @param vo AdamsLoginDTO
	 * @return List<AdamsMenuDTO>
	 * @exception Exception
	 */
	public List<AdamsMenuDTO> selectMenuTreeList(List<AdamsMenuDTO> adamsMenuDTOs) throws Exception {
		log.debug(" ================= AdamsLoginService.selectMenuTreeList [START]] ===================== ");
		List<AdamsMenuDTO> rAdamssMenuDTOs = null;
		AdamsMenuDTO       uAdamsMenuDTO   = null;
		List<AdamsMenuDTO> sAdamssMenuDTOs = null;
		int                           cnt  = 0;
		
		// 2. 결과를 리턴한다.
		if (adamsMenuDTOs != null && adamsMenuDTOs.size() != 0 && !adamsMenuDTOs.get(0).getMenuId().equals("")) {
			rAdamssMenuDTOs = new ArrayList<>();

			log.debug(" ================= adamsLoginDTOs ===================== ");
			
			for( AdamsMenuDTO adamsLoginDTO : adamsMenuDTOs ) {
				if( "0".equals( adamsLoginDTO.getLevel() ) ) {

					log.debug(" ================= adamsLoginDTO LEVEL 0 : " + adamsLoginDTO.getMenuNmKor() + " ===================== ");
					if( cnt > 0 ) {
						uAdamsMenuDTO.setAdamsMenuDTOList(sAdamssMenuDTOs);
						rAdamssMenuDTOs.add(uAdamsMenuDTO);
					}
					
					uAdamsMenuDTO = new AdamsMenuDTO();
					uAdamsMenuDTO.setMenuId(adamsLoginDTO.getMenuId());
					uAdamsMenuDTO.setMenuNmKor(adamsLoginDTO.getMenuNmKor());
					uAdamsMenuDTO.setMenuNmEng(adamsLoginDTO.getMenuNmEng());
					uAdamsMenuDTO.setUpprMenuId(adamsLoginDTO.getUpprMenuId());
					uAdamsMenuDTO.setMenuSrtOrd(adamsLoginDTO.getMenuSrtOrd());
					uAdamsMenuDTO.setMenuDesc(adamsLoginDTO.getMenuDesc());
					uAdamsMenuDTO.setPgmUrl(adamsLoginDTO.getPgmUrl());
					uAdamsMenuDTO.setLevel(adamsLoginDTO.getLevel());
					uAdamsMenuDTO.setSort(adamsLoginDTO.getSort());
					sAdamssMenuDTOs = new ArrayList<>();
					cnt++;
				} else {
					log.debug(" ================= adamsLoginDTO LEVEL 1 : " + adamsLoginDTO.getMenuNmKor() + " ===================== ");
					sAdamssMenuDTOs.add(adamsLoginDTO);
				}
				
			}
			uAdamsMenuDTO.setAdamsMenuDTOList(sAdamssMenuDTOs);
			rAdamssMenuDTOs.add(uAdamsMenuDTO);
			
			return rAdamssMenuDTOs;
		} else {
			rAdamssMenuDTOs = new ArrayList<>();
		}

		log.debug(" ================= AdamsLoginService.selectMenuTreeList [END]] ===================== ");
		return rAdamssMenuDTOs;
	}

	/**
	 * 고객사 목록을 조회한다
	 * @param vo AdamsLoginDTO
	 * @return List<AdamsCsNoDTO>
	 * @exception Exception
	 */
	public List<AdamsCsNoDTO> selectCsNoList(AdamsLoginDTO vo) throws Exception {

		// 1. 사용자 메뉴 옥록을 확인한다.
		List<AdamsCsNoDTO> adamsCsNoDTOs = adamsLoginDAO.selectCsNoList(vo);

		// 2. 결과를 리턴한다.
		if (adamsCsNoDTOs != null && adamsCsNoDTOs.size() != 0 && !adamsCsNoDTOs.get(0).getCsNo().equals("")) {
			return adamsCsNoDTOs;
		} else {
			adamsCsNoDTOs = new ArrayList<>();
		}

		return adamsCsNoDTOs;
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
	 * 사용자 로그인 이력을 저장한다.
	 * @param vo AdamsLoginDTO
	 * @return boolean
	 * @exception Exception
	 */
	public boolean insertLoginHist(AdamsLoginDTO vo, HttpServletRequest request) throws Exception {

		boolean result = true;

		// 1. 로그인 정보가 있는지 확인한다.
		if (vo == null || vo.getUsrId() == null || "".equals(vo.getUsrId())) {
			return false;
		}
		
		// 2. 사용자의 접속IP를 가져온다. 
		String ip = request.getHeader("X-Forwarded-For");
		
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    
	    vo.setAccIp(ip);

		// 3. 신규 비밀번호를 DB에 저장한다.
		adamsLoginDAO.insertLoginHist(vo);

		return result;
	}

	/**
	 * 사용자 로그인 이력을 저장한다.
	 * @param vo AdamsLoginDTO
	 * @return boolean
	 * @exception Exception
	 */
	public boolean updateUsrPassword(AdamsLoginDTO vo) throws Exception {

		boolean result = true;

		// 1. 사용자 비밀번호 변경 정보가 있는지 확인한다.
		if (vo == null || vo.getUsrId() == null || "".equals(vo.getUsrId()) || vo.getUsrPassword() == null || "".equals(vo.getUsrPassword())) {
			return false;
		}
		
		// 3. 신규 비밀번호를 DB에 저장한다.
		adamsLoginDAO.updatePassword(vo);

		return result;
	}

	/**
	 * 비밀번호를 찾는다.
	 * @param vo AdamsLoginDTO
	 * @return boolean
	 * @exception Exception
	 */
	public boolean searchPassword(AdamsFindPwDTO vo) throws Exception {

		boolean result = true;

		// 1. 아이디, 이름, 이메일주소, 비밀번호 힌트, 비밀번호 정답이 DB와 일치하는 사용자 Password를 조회한다.
		AdamsLoginDTO adamsLoginDTO = adamsLoginDAO.searchPassword(vo);
		if (adamsLoginDTO == null || adamsLoginDTO.getUsrId() == null || "".equals(adamsLoginDTO.getUsrId())) {
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
		pwVO.setUsrId(adamsLoginDTO.getUsrId());
		pwVO.setCsNo(adamsLoginDTO.getCsNo());
		pwVO.setUsrNewPassword(newpassword);
		//pwVO.setUsrDvCd(vo.getUsrDvCd());
		adamsLoginDAO.updatePasswordReset(pwVO);
		
		// 4. 임시 비밀번호를 사용자 이메일로 전송한다.
		EmailDTO emailDTO = new EmailDTO(); 
		
		emailDTO.setRecipientAddress(adamsLoginDTO.getUsrEmail());
		//emailDTO.setSubject("ADAMS : 사용자 임시 비밀번호 발송");
		emailDTO.setSubject("ADAMS: Send User Temporary Password");
		emailDTO.setBodyPlainText("User Temporary Password : " + newpassword);
		
		EmailUtil.sendEmail(emailDTO);
		
		return result;
	}
}
package com.rds.adams.web.common.login.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.egovframe.rte.fdl.cmmn.trace.LeaveaTrace;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.adams.web.common.AdamsConstant;
import com.rds.adams.web.common.jwt.AdamsJwtTokenUtil;
import com.rds.adams.web.common.login.dto.AdamsCsNoDTO;
import com.rds.adams.web.common.login.dto.AdamsFindPwDTO;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;
import com.rds.adams.web.common.login.dto.AdamsMenuDTO;
import com.rds.adams.web.common.login.dto.AdamsNewCsDTO;
import com.rds.adams.web.common.login.dto.AdamsResultDTO;
import com.rds.adams.web.common.login.service.AdamsLoginService;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * 일반 로그인을 처리하는 컨트롤러 클래스
 * @author 공통서비스 개발팀 박지욱
 * @since 2009.03.06
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일      수정자      수정내용
 *  -------            --------        ---------------------------
 *  2009.03.06  박지욱     최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *  
 *
 *  </pre>
 */
@Slf4j
@RestController
@Tag(name="AdamsLoginController",description = "로그인 관련")
public class AdamsLoginController {

	/** EgovLoginService */
	@Resource(name = "adamsLoginService")
	private AdamsLoginService adamsLoginService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** TRACE */
	@Resource(name = "leaveaTrace")
	LeaveaTrace leaveaTrace;
	
	/** JWT */
	@Autowired
    private AdamsJwtTokenUtil adamsJwtTokenUtil;

	/**
	 * 일반 로그인을 처리한다
	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */

	@Operation(
			summary = "일반 로그인",
			description = "일반 로그인 처리",
			tags = {"AdamsLoginController"}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "로그인 성공"),
			@ApiResponse(responseCode = "300", description = "로그인 실패")
	})
	@RequestMapping(value = "/auth/adamsLogin", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.TEXT_HTML_VALUE})
	public HashMap<String, Object> selectLoginInfo(@RequestBody AdamsLoginDTO adamsLoginDTO, HttpServletRequest request) throws Exception {
	    HashMap<String, Object> resultMap = processLogin(adamsLoginDTO, request, false);
	    String nextPage = ""; 
	    		
	    // 로그인 성공 시 페이지 이동 정보 추가
	    if ("200".equals(resultMap.get("resultCode"))) {
	        
	    	AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
	    	
	    	// 로그인 성공시 로그린 이력 저장
	    	adamsLoginService.insertLoginHist(sAdamsLoginDTO, request);
	    	
	    	nextPage = "myPage"; // 로그인 후 이동할 기본 페이지 
	    	
	    	if ( "Y".equals(sAdamsLoginDTO.getPasswordInitYn()) ) {
	    		// 비밀번호 초기화 된 경우
	    		nextPage = "pwChange";
		        resultMap.put("loginMsg", "Your password has been reset. You will be taken to the reset screen.");
	    	} else if ( "9".equals(sAdamsLoginDTO.getStatDvCd()) ) {
	    		// 사용자의 상태가 종료인 경우 로그인 페이지로
	    		nextPage = "login";
		        resultMap.put("loginMsg", "This user is not available.");
	    	}
	    	
	        resultMap.put("redirectUrl", nextPage);
	    } else {
	        resultMap.put("loginMsg", "Please check your ID or password.");
	        resultMap.put("redirectUrl", "login");
	    }
	    
	    return resultMap;
	}
	
	private HashMap<String, Object> processLogin(AdamsLoginDTO adamsLoginDTO, HttpServletRequest request, boolean isJwtLogin) throws Exception {
		HashMap<String,Object>  resultMap         = new HashMap<String,Object>();
		List<AdamsMenuDTO>      adamsMenuDTOs     = new ArrayList<>();
		List<AdamsMenuDTO>      adamsMenuTreeDTOs = new ArrayList<>();

		// 1. 일반 로그인 처리
		AdamsLoginDTO adamsLoginResultDTO = adamsLoginService.selectLoginInfo(adamsLoginDTO);

		if (adamsLoginResultDTO != null && adamsLoginResultDTO.getUsrId() != null && !adamsLoginResultDTO.getUsrId().equals("")) {

			//log.debug("===>>> adamsLoginDTO.getCsNo()  = "+adamsLoginDTO.getCsNo());
			log.debug("===>>> adamsLoginDTO.getUsrId() = "+adamsLoginDTO.getUsrId());
			//log.debug("===>>> loginVO.getPassword() = "+loginVO.getPassword());
			
			String jwtToken = adamsJwtTokenUtil.generateToken(adamsLoginResultDTO);
			
			String username = adamsJwtTokenUtil.getUserSeFromToken(jwtToken);
	    	log.debug("Dec jwtToken username = "+username);
	    	
	    	adamsMenuDTOs     = adamsLoginService.selectMenuList(adamsLoginResultDTO);
	    	adamsMenuTreeDTOs = adamsLoginService.selectMenuTreeList(adamsMenuDTOs);
	    	 
	    	//서버사이드 권한 체크 통과를 위해 삽입
	    	//EgovUserDetailsHelper.isAuthenticated() 가 그 역할 수행. DB에 정보가 없으면 403을 돌려 줌. 로그인으로 튕기는 건 프론트 쪽에서 처리
	    	request.getSession().setAttribute(AdamsConstant.SESSION_LOGIN_INFO		, adamsLoginResultDTO);
	    	request.getSession().setAttribute(AdamsConstant.SESSION_MENU_FLATLIST	, adamsMenuDTOs);
	    	request.getSession().setAttribute(AdamsConstant.SESSION_MENU_TREELIST	, adamsMenuTreeDTOs);
	    	//request.getSession().setAttribute("LoginVO", loginResultVO);
	    	
			//resultMap.put("resultVO"        , adamsLoginResultDTO);
			//resultMap.put("resultMenuVO"    , adamsMenuDTOs);
			//resultMap.put("resultMenuTreeVO", adamsMenuTreeDTOs);
			if (isJwtLogin) {
	            //resultMap.put("jToken", jwtToken);
	        }
			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "성공 !!!");
		} else {
			//resultMap.put("resultVO"        , adamsLoginResultDTO);
			//resultMap.put("resultMenuVO"    , adamsMenuDTOs);
			//resultMap.put("resultMenuTreeVO", adamsMenuTreeDTOs);
			resultMap.put("resultCode"   , "300");
			resultMap.put("resultMessage", egovMessageSource.getMessage("fail.common.login"));
		}

		return resultMap;

	}

	@Operation(
			summary = "JWT 로그인",
			description = "JWT 로그인 처리",
			tags = {"AdamsLoginController"}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "로그인 성공"),
			@ApiResponse(responseCode = "300", description = "로그인 실패")
	})
	@PostMapping(value = "/auth/adamsLogin-jwt")
	public HashMap<String, Object> selectLoginJWTInfo(@RequestBody AdamsLoginDTO adamsLoginDTO, HttpServletRequest request, ModelMap model) throws Exception {
		HashMap<String, Object> resultMap = processLogin(adamsLoginDTO, request, true);
		String nextPage = ""; 
		
	    // 로그인 성공 시 페이지 이동 정보 추가
	    if ("200".equals(resultMap.get("resultCode"))) {

	    	AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);
	    	
	    	// 로그인 성공시 로그린 이력 저장
	    	adamsLoginService.insertLoginHist(sAdamsLoginDTO, request);
	    	
	    	nextPage = "myPage"; // 로그인 후 이동할 기본 페이지 
	    	
	    	if ( "Y".equals(sAdamsLoginDTO.getPasswordInitYn()) ) {
	    		// 비밀번호 초기화 된 경우
	    		nextPage = "pwChange";
		        resultMap.put("loginMsg", "Your password has been reset. You will be taken to the reset screen.");
	    	} else if ( "9".equals(sAdamsLoginDTO.getStatDvCd()) ) {
	    		// 사용자의 상태가 종료인 경우 로그인 페이지로
	    		nextPage = "login";
		        resultMap.put("loginMsg", "This user is not available.");
	    	}
	    	
	        resultMap.put("redirectUrl", nextPage);
	    }
	    
	    return resultMap;
	}

	/**
	 * 로그아웃한다.
	 * @return resultVO
	 * @exception Exception
	 */
	@Operation(
			summary = "로그아웃",
			description = "로그아웃 처리(JWT,일반 관계 없이)",
			security = {@SecurityRequirement(name = "Authorization")},
			tags = {"AdamsLoginController"}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "로그아웃 성공"),
	})
	@GetMapping(value = "/auth/adamsLogout")
	public AdamsResultDTO actionLogoutJSON(HttpServletRequest request, HttpServletResponse response) throws Exception {

		AdamsResultDTO adamsResultDTO = new AdamsResultDTO();

		new SecurityContextLogoutHandler().logout(request, response, null);

		adamsResultDTO.setResultCode(ResponseCode.SUCCESS.getCode());
		adamsResultDTO.setResultMessage(ResponseCode.SUCCESS.getMessage());

		return adamsResultDTO;
	}

	/**
	 * 고객 목록을 조회한다
	 * @param vo - 빈 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 고객 목록
	 * @exception Exception
	 */
	@Operation(
			summary = "고객 목록",
			description = "고객 목록 조회",
			tags = {"AdamsLoginController"}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "고객 조회 성공"),
			@ApiResponse(responseCode = "300", description = "고객 조회 실패")
	})
	@RequestMapping(value = "/auth/adamsLoginCs", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.TEXT_HTML_VALUE})
	public HashMap<String, Object> selectCsNoList(@RequestBody AdamsLoginDTO adamsLoginDTO, HttpServletRequest request) throws Exception {
	    HashMap<String, Object> resultMap = new HashMap<String,Object>();

		// 1. 일반 로그인 처리
	    List<AdamsCsNoDTO> adamsCsNoDTOs = adamsLoginService.selectCsNoList(adamsLoginDTO);

		if (adamsCsNoDTOs != null && adamsCsNoDTOs.get(0).getCsNo() != null && !adamsCsNoDTOs.get(0).getCsNo().equals("")) {

			resultMap.put("resultVO"    , adamsCsNoDTOs);
			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "성공 !!!");
		} else {
			resultMap.put("resultVO"    , adamsCsNoDTOs);
			resultMap.put("resultCode"   , "300");
			resultMap.put("resultMessage", egovMessageSource.getMessage("fail.common.login"));
		}

		return resultMap;
	}

	/**
	 * 초기화된 비밀번호를 변경 한다
	 * @param vo - 빈 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 고객 목록
	 * @exception Exception
	 */
	@Operation(
			summary = "사용자 비밀번호",
			description = "사용자 비밀번호 변경",
			tags = {"AdamsLoginController"}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "비밀번호 변경 성공"),
			@ApiResponse(responseCode = "300", description = "비밀번호 변경 실패")
	})
	@RequestMapping(value = "/auth/adamsLoginPw", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.TEXT_HTML_VALUE})
	public HashMap<String, Object> updateUsrPassword(@RequestBody AdamsLoginDTO adamsLoginDTO, HttpServletRequest request) throws Exception {
	    HashMap<String, Object> resultMap = new HashMap<String,Object>();
	    boolean  bResult = false;
	    String nextPage = ""; 
	    
	    // 1. 세션에서 사용자 정보 가져오기
	    AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute(AdamsConstant.SESSION_LOGIN_INFO);

	    if ( sAdamsLoginDTO != null && sAdamsLoginDTO.getUsrId() != null && !sAdamsLoginDTO.getUsrId().equals("")) {
		    // 2. 새 비밀번호 적용을 위한 세션정보 가져오기 
	    	adamsLoginDTO.setCsNo(sAdamsLoginDTO.getCsNo());
	    	adamsLoginDTO.setUsrId(sAdamsLoginDTO.getUsrId());
	    	adamsLoginDTO.setUsrPassword(sAdamsLoginDTO.getUsrPassword());
		    
			// 3. 비밀번호 변경 처리
		    bResult = adamsLoginService.updateUsrPassword(adamsLoginDTO);
	    }
	    
		if (bResult) {
			
			// 4. 세션정보 초기화
			HttpSession session = request.getSession(false); // 현재 세션을 가져옴, 없으면 null 반환
		    if (session != null) {
		        session.invalidate(); // 세션 무효화, 모든 세션 데이터를 제거하고 세션 종료
		        log.info("Session has been invalidated.");
		    } else {
		        log.info("No active session to clear.");
		    }
			
			// 사용자 재로그인 페이지로
    		nextPage = "login";
    		
	        resultMap.put("redirectUrl", nextPage);
			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "성공 !!!");
		} else {
			resultMap.put("resultCode"   , "300");
			resultMap.put("resultMessage", egovMessageSource.getMessage("fail.common.login"));
		}

		return resultMap;
	}

	/**
	 * 초기화된 비밀번호를 변경 한다
	 * @param vo - 빈 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 고객 목록
	 * @exception Exception
	 */
	@Operation(
			summary = "사용자 비밀번호 찾기",
			description = "사용자 비밀번호 찾기",
			tags = {"AdamsLoginController"}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "비밀번호 찾기 성공"),
			@ApiResponse(responseCode = "300", description = "비밀번호 찾기 실패")
	})
	@RequestMapping(value = "/auth/adamsFindPw", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.TEXT_HTML_VALUE})
	public HashMap<String, Object> searchPassword(@RequestBody AdamsFindPwDTO adamsFindPwDTO, HttpServletRequest request) throws Exception {
	    HashMap<String, Object> resultMap = new HashMap<String,Object>();
	    boolean  bResult = false;
	    String nextPage = ""; 
	    
	    // 1. 비밀번호 찾기 처리
		bResult = adamsLoginService.searchPassword(adamsFindPwDTO);
	    
		if (bResult) {
			
			// 사용자 재로그인 페이지로
    		nextPage = "login";
    		
	        resultMap.put("redirectUrl", nextPage);
			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "성공 !!!");
		} else {
			resultMap.put("resultCode"   , "300");
			resultMap.put("resultMessage", egovMessageSource.getMessage("fail.common.login"));
		}

		return resultMap;
	}

	/**
	 * 신규 고객 신청 정보를 저장 한다
	 * @param vo - 빈 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 고객 목록
	 * @exception Exception
	 */
	@Operation(
			summary = "신규 고객 신청",
			description = "사신규 고객 신청 정보 저장",
			tags = {"AdamsLoginController"}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "신규 고객 신청 성공"),
			@ApiResponse(responseCode = "300", description = "신규 고객 신청 실패")
	})
	@RequestMapping(value = "/auth/adamsNewCs", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.TEXT_HTML_VALUE})
	public HashMap<String, Object> insertNewCs(@RequestBody AdamsNewCsDTO adamsNewCsDTO, HttpServletRequest request) throws Exception {
	    HashMap<String, Object> resultMap = new HashMap<String,Object>();
	    boolean  bResult = false;
	    String nextPage = ""; 
	    
	    // 1. 비밀번호 찾기 처리
		bResult = adamsLoginService.insertNewCs(adamsNewCsDTO);
	    
		if (bResult) {
			
			// 사용자 재로그인 페이지로
    		nextPage = "login";
    		
	        resultMap.put("redirectUrl", nextPage);
			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "성공 !!!");
		} else {
			resultMap.put("resultCode"   , "300");
			resultMap.put("resultMessage", egovMessageSource.getMessage("fail.common.login"));
		}

		return resultMap;
	}
}
package com.rds.adams.web.com.login.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.rds.adams.web.com.jwt.AdamsJwtTokenUtil;
import com.rds.adams.web.com.login.dto.AdamsLoginDTO;
import com.rds.adams.web.com.login.dto.AdamsMenuDTO;
import com.rds.adams.web.com.login.dto.AdamsResultDTO;
import com.rds.adams.web.com.login.service.AdamsLoginService;

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
		HashMap<String,Object>  resultMap = new HashMap<String,Object>();
		List<AdamsMenuDTO> adamsLoginDTOs = new ArrayList<>();

		// 1. 일반 로그인 처리
		AdamsLoginDTO adamsLoginResultDTO = adamsLoginService.selectLoginInfo(adamsLoginDTO);

		if (adamsLoginResultDTO != null && adamsLoginResultDTO.getUsrId() != null && !adamsLoginResultDTO.getUsrId().equals("")) {

			log.debug("===>>> adamsLoginDTO.getCsNo()  = "+adamsLoginDTO.getCsNo());
			log.debug("===>>> adamsLoginDTO.getUsrId() = "+adamsLoginDTO.getUsrId());
			//log.debug("===>>> loginVO.getPassword() = "+loginVO.getPassword());
			
			String jwtToken = adamsJwtTokenUtil.generateToken(adamsLoginResultDTO);
			
			String username = adamsJwtTokenUtil.getUserSeFromToken(jwtToken);
	    	log.debug("Dec jwtToken username = "+username);
	    	
	    	adamsLoginDTOs = adamsLoginService.selectMenuList(adamsLoginResultDTO);
	    	 
	    	//서버사이드 권한 체크 통과를 위해 삽입
	    	//EgovUserDetailsHelper.isAuthenticated() 가 그 역할 수행. DB에 정보가 없으면 403을 돌려 줌. 로그인으로 튕기는 건 프론트 쪽에서 처리
	    	request.getSession().setAttribute("LoginVO"   , adamsLoginResultDTO);
	    	request.getSession().setAttribute("MenuVOList", adamsLoginDTOs);
	    	//request.getSession().setAttribute("LoginVO", loginResultVO);
	    	
			resultMap.put("resultVO"    , adamsLoginResultDTO);
			resultMap.put("resultMenuVO", adamsLoginDTOs);
			resultMap.put("resultCode"   , "200");
			resultMap.put("resultMessage", "성공 !!!");
		} else {
			resultMap.put("resultVO"    , adamsLoginResultDTO);
			resultMap.put("resultMenuVO", adamsLoginDTOs);
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
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<AdamsMenuDTO> adamsLoginDTOs = new ArrayList<>();

		// 1. 일반 로그인 처리
		AdamsLoginDTO adamsLoginResultDTO = adamsLoginService.selectLoginInfo(adamsLoginDTO);
		
		if (adamsLoginResultDTO != null && adamsLoginResultDTO.getUsrId() != null && !adamsLoginResultDTO.getUsrId().equals("")) {

			log.debug("===>>> adamsLoginDTO.getCsNo()  = "+adamsLoginDTO.getCsNo());
			log.debug("===>>> adamsLoginDTO.getUsrId() = "+adamsLoginDTO.getUsrId());
			//log.debug("===>>> loginVO.getPassword() = "+loginVO.getPassword());
			
			String jwtToken = adamsJwtTokenUtil.generateToken(adamsLoginResultDTO);
			
			String username = adamsJwtTokenUtil.getUserSeFromToken(jwtToken);
	    	log.debug("Dec jwtToken username = "+username);
	    	
	    	adamsLoginDTOs = adamsLoginService.selectMenuList(adamsLoginResultDTO);
	    	 
	    	//서버사이드 권한 체크 통과를 위해 삽입
	    	//EgovUserDetailsHelper.isAuthenticated() 가 그 역할 수행. DB에 정보가 없으면 403을 돌려 줌. 로그인으로 튕기는 건 프론트 쪽에서 처리
	    	request.getSession().setAttribute("LoginVO"   , adamsLoginResultDTO);
	    	request.getSession().setAttribute("MenuVOList", adamsLoginDTOs);
	    	//request.getSession().setAttribute("LoginVO", loginResultVO);
	    	
			resultMap.put("resultVO", adamsLoginResultDTO);
			resultMap.put("resultMenuVO", adamsLoginDTOs);
			resultMap.put("jToken", jwtToken);
			resultMap.put("resultCode", "200");
			resultMap.put("resultMessage", "성공 !!!");
			
		} else {
			resultMap.put("resultVO", adamsLoginResultDTO);
			resultMap.put("resultMenuVO", adamsLoginDTOs);
			resultMap.put("resultCode", "300");
			resultMap.put("resultMessage", egovMessageSource.getMessage("fail.common.login"));
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
}
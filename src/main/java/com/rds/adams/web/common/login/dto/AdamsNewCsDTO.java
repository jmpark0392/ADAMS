package com.rds.adams.web.common.login.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 9. 25.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-09-11 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@Schema(description = "신규 고객 정보 DTO")
@Getter
@Setter
public class AdamsNewCsDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8274004534207618049L;

    @Schema(description = "고객사번호")
    private String csNo;

    @Schema(description = "회사명")
    private String compNoDvCd;

    @Schema(description = "회사명")
    private String compNo;

    @Schema(description = "회사명")
    private String compNm;

    @Schema(description = "회사명")
    private String repPhNo;

    @Schema(description = "회사명")
    private String reperNm;

    @Schema(description = "회사명")
    private String ptbNm;

    @Schema(description = "회사명")
    private String ptbPhNo;

    @Schema(description = "회사명")
    private String ptbEmail;

    @Schema(description = "회사명")
    private String usrPassword;

    @Schema(description = "회사명")
    private String postNo;

    @Schema(description = "회사명")
    private String addrs;

    @Schema(description = "회사명")
    private String dtlsAddrs;

    @Schema(description = "회사명")
    private String countryNmEng;
	
	
}

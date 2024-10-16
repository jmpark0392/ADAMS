package com.rds.adams.web.adm.usr.dto;

import javax.validation.constraints.Email;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 10. 10.
 * @author : PARK JUNMIN
 * E-MAIL  : jm.park@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-10-10 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@Schema(description = "고객사 정보 조회 결과 DTO")
@ToString
@Getter
@Setter
public class ADMUSR001M0R0DTO {

    @Schema(description = "고객사번호")
    private String csNo;
	
    @Schema(description = "국가명")
    private String CountryNmEng;

    @Schema(description = "회사번호구분코드")
    private int CompNoDvCd;

    @Schema(description = "회사번호")
    private String CompNo;
	
    @Schema(description = "회사명")
    private String CompNm;
	
    @Schema(description = "대표자명")
    private String ReperNm;

    @Schema(description = "대표전화번호")
    private String RepPhNo;

    @Schema(description = "담당자명")
    private String PtbNm;

    @Schema(description = "담당자전화번호")
    private String PtbPhNo;
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @Schema(description = "담당자이메일")
    private String PtbEmail;

    @Schema(description = "우편번호")
    private String PostNo;

    @Schema(description = "기본주소")
    private String Addrs;

    @Schema(description = "상세주소")
    private String DtlsAddrs;

    @Schema(description = "사용시작일시")
    private String UseStrDtm;

    @Schema(description = "최초등록일시")
    private String FrstRegDtm;

}
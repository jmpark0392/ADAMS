package com.rds.adams.web.com.login.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 9. 05.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-09-05 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@Schema(description = "사용자 정보 DTO")
@Getter
@Setter
public class AdamsLoginDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8274004534207618049L;

    @Schema(description = "고객사번호")
    private String csNo;

    @Schema(description = "사용자구분코드")
    private String usrDvCd;

    @Schema(description = "사용자ID")
    private String usrId;

    @Schema(description = "사용자명")
    private String usrNm;

    @Schema(description = "사용자비밀번호")
    private String usrPassword;

    @Schema(description = "사용자신규비밀번호")
    private String usrNewPassword;

    @Schema(description = "사용자전화번호")
    private String usrPhNo;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @Schema(description = "사용자이메일")
    private String usrEmail;

    @Schema(description = "사번")
    private String empNo;

    @Schema(description = "상태구분코드")
    private String statDvCd;

    @Schema(description = "사용시작일시")
    private String useStrDtm;

    @Schema(description = "사용종료일시")
    private String useEndDtm;

    @Schema(description = "비밀번호변경일시")
    private String passwordUpdDtm;

    @Schema(description = "비밀번호초기화여부")
    private String passwordInitYn;

    @Schema(description = "서비스코드")
    private String srvcCd;
	
	
}

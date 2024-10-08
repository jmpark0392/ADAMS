package com.rds.adams.web.opn.usr.dto;

import javax.validation.constraints.Email;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 10. 04.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-10-04 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@Schema(description = "사용자 정보 조회 결과 DTO")
@ToString
@Getter
@Setter
public class OPNUSR003M0R0DTO {


    @Schema(description = "수정아이디")
    private String updId;

    @Schema(description = "시퀀스")
    private int seqNo;
    
    @Schema(description = "고객사번호")
    private String csNo;

    @Schema(description = "회사명")
    private String compNm;

    @Schema(description = "사용자구분코드")
    private String usrDvCd;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @Schema(description = "사용자아이디")
    private String usrId;
    @Schema(description = "old사용자아이디")
    private String oldUsrId;

    @Schema(description = "사용자비밀번호")
    private String usrPassword;

    @Schema(description = "사용자명")
    private String usrNm;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @Schema(description = "사용자이메일")
    private String usrEmail;

    @Schema(description = "사용자폰넘버")
    private String usrPhNo;

    @Schema(description = "상태구분코드")
    private String statDvCd;

    @Schema(description = "old상태구분코드")
    private String oldStatDvCd;

    @Schema(description = "사용시작일시")
    private String useStrDtm;

    @Schema(description = "사용종료일시")
    private String useEndDtm;

    @Schema(description = "비밀번호변경일시")
    private String passwordUpdDtm;

    @Schema(description = "최종수정사원번호")
    private String fnlUpdEmpNo;

    @Schema(description = "최종수정일시")
    private String fnlUpdDtm;

    @Schema(description = "최초등록사원번호")
    private String frstRegEmpNo;

    @Schema(description = "최초등록일시")
    private String frstRegDtm;

}
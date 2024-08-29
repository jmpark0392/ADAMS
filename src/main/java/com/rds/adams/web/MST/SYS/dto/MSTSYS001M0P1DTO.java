package com.rds.adams.web.MST.SYS.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 6. 28.
 * @author : BAE BYUNGSUN
 * E-MAIL  : bs.bae@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-06-28 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter
public class MSTSYS001M0P1DTO {
	
	private String empNo;
    private String empNm;
    private String roleCd;
    private String email;
    private String pwd;
    private String useYn;

}
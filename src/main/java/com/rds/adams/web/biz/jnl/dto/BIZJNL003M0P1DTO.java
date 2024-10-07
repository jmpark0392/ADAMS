package com.rds.adams.web.biz.jnl.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 1. 9.
 * @author : JEONG HYEONSEUNG
 * E-MAIL  : hs.jeong@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-01-09 : 최초 등록
 * 2024-06-11 : 코드 수정
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter
public class BIZJNL003M0P1DTO {
	
	private int rowNumber;
	private String stdYymm;  /* 기준년월 */
	private String jrnlNo; /* 분개번호 */
	private String atitCd;  /* 계정과목코드 */
	private String atitNm;  /* 계정과목명 */
	private String drCrDvCd;  /* 차대구분 */
	private String jrnlAmt;  /* 분개금액 */
	private String frstRegEmpNo;  /* 등록사용자ID */
	private String frstRegDtm;  /* 등록일 */
	
}


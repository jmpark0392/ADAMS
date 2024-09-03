package com.rds.adams.web.wrk.bat.dto;

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
public class WRKBAT001M0P1DTO {
	
	//private int itmNm;  /* 항목 */
	private String batProgId; /* 배치프로그램ID */
	private String batProgNm; /* 배치프로그램명 */
	private String upProgId; /* 상위프로그램ID */
	private String lwstProgYn;  /* 최하위프로그램여부 */
    private String exePrd; /* 실행주기 */
	private String mainEmpNo; /* 주담당자 */
	private String subEmpNo; /* 부담당자 */
	private String etcDesc;    /* 비고 */
	private String useYn; /* 사용여부 */  
}
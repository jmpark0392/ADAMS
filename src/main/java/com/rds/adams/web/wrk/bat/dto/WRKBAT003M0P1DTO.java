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
public class WRKBAT003M0P1DTO {

	private String stdYymm;  /* 기준년월 */
	private String batExeId;  /* 배치실행ID" */
	private String batProgId;  /* 배치프로그램ID */
	private String batProgNm;  /* 배치프로그램명 */
	private String batExeRstCd;  /* 배치실행결과코드 */
	private String batExeErrCd;  /* 배치실행에러코드 */
	private String mainEmpNo;  /* 주담당자 */
}

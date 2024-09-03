package com.rds.adams.web.biz.fst.dto;

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
public class BIZFST001M0R0DTO {
	
	private int rowNumber;
	private String stdYymm;  /* 기준년월 */
	private String atitCd;  /* 계정과목코드 */
	private String atitNm;  /* 계정과목명 */
	private String fsDvCd;  /* 재무제표구분코드 */
	private int basAmt;  /* 기초금액 */
	private int drAmt;  /* 차변금액 */
	private int crAmt;  /* 대변금액 */
	private int entmAmt;  /* 기말금액 */
	private String regUsrid;  /* 등록사용자ID */
	private String regDt;  /* 등록일 */
	
}


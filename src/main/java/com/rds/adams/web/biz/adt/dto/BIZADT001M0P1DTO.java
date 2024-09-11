package com.rds.adams.web.biz.adt.dto;

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
public class BIZADT001M0P1DTO {
	
	private String stdYymm;  /* 기준년월 */
	private String seqNo;  /* 일련번호 */
	private String atitCd;  /* 계정과목코드 */
	private String atitNm;  /* 계정과목명 */
	private String insuPlItmCd;  /* 보험손익항목코드 */
	private int acntAmt;  /* 계정금액 */
	private int insuPlItmAmt;  /* 보험손익항목금액 */
	private int diffAmt;  /* 차이금액 */

	
}


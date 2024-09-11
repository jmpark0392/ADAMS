package com.rds.adams.web.biz.ins.dto;

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
public class BIZINS003M0P1DTO {
	
	private int rowNumber;
	private String stdYymm;  /* 기준년월 */
	private String inscDvCd;  /* 보험계약구분코드 */
	private String valuMetdCd;  /* 평가방법구분코드 */
	private String insuPlChngDvCd;  /* 보험손익변동구분코드 */
	private String ptfCd; /* 포트폴리오 */
	private int basAmt;  /* 기초금액 */
	private int ociAmt;  /* OCI금액 */
	private int newContAmt;  /* 신계약금액 */
	private int intEfftAmt;  /* 이자효과금액 */
	private int estmPrm;  /* 예상보험료 */
	private int estmFee;  /* 예상수수료 */
	private int estmNewContCclsAmt;  /* 예상신계약체결금액 */
	private int estmFeeRfndAmt;  /* 예상수수료환입금액 */
	private int estmContMtnAmt;  /* 예상계약유지금액 */
	private int estmIvsgExpAmt;  /* 예상손해조사금액 */
	private int atsAssmUpdAmt;  /* 계리적가정변경금액 */
	private int exrtEfftAmt;  /* 환율효과금액 */
	private int entmAmt;  /* 기말금액 */

	
}


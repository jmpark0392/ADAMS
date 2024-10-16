package com.rds.adams.web.biz.ins.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "보험손익RA DTO")
@ToString
@Getter
@Setter
public class BIZINS002M0P1DTO {
	
	@Schema(description = "고객사번호")
	private String csNo;
	
	@Schema(description = "행번호")
	private int rowNumber;
	
	@Schema(description = "기준년월")
	private String stdYymm;
	
	@Schema(description = "보험계약구분코드")
	private String inscDvCd;
	
	@Schema(description = "평가방법구분코드")
	private String valuMetdCd;
	
	@Schema(description = "포트폴리오")
	private String ptfCd;
	
	@Schema(description = "기초금액")
	private int basAmt;
	
	@Schema(description = "OCI금액")
	private int ociAmt;
	
	@Schema(description = "신계약금액")
	private int newContAmt;
	
	@Schema(description = "이자효과금액")
	private int intEfftAmt;
	
	@Schema(description = "예상보험료")
	private int estmPrm;
	
	@Schema(description = "예상수수료")
	private int estmFee;
	
	@Schema(description = "예상신계약체결금액")
	private int estmNewContCclsAmt;
	
	@Schema(description = "예상수수료환입금액")
	private int estmFeeRfndAmt;
	
	@Schema(description = "예상계약유지금액")
	private int estmContMtnAmt;
	
	@Schema(description = "예상손해조사금액")
	private int estmIvsgExpAmt;
	
	@Schema(description = "계리적가정변경금액")
	private int atsAssmUpdAmt;
	
	@Schema(description = "환율효과금액")
	private int exrtEfftAmt;
	
	@Schema(description = "기말금액")
	private int entmAmt;
}


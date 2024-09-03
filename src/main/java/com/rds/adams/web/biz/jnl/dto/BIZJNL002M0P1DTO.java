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
public class BIZJNL002M0P1DTO {
	
	private String inscDvCd;  /* 보험계약구분코드 */
	private String valMetdCd; /* 평가방법코드 */
	private String lvl1Cd;  /* 레벨1 */
	private String lvl2Cd;  /* 레벨2 */
	private String lvl3Cd;  /* 레벨3 */
	private String drAcSubjCd;  /* 차변계정코드 */
	private String crAcSubjCd;  /* 대변계정코드 */
	private String etcDesc;  /* 기타내용 */
	private String useYn;  /* 사용여부 */
	
}


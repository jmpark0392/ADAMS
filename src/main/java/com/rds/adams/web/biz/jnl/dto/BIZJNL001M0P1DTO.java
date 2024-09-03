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
public class BIZJNL001M0P1DTO {
	
	private String atitCd;  /* 계정과목코드 */
	private String atitKorNm; /* 계정과목한글명 */
	private String atitEngNm;  /* 계정과목영문명 */
	private String acLvlCd;  /* 계정레벨코드 */
	private String hgrkAtitCd;  /* 상위계정과목코드 */
	private String bkgAcYn;  /* 기표계정여부 */
	private String fsDvCd;  /* 재무제표구분코드 */
	private String acDvCd;  /* 계정구분코드 */
	private String acKindCd;  /* 계정종류코드 */
	private String appStDt;  /* 적용시작일자 */
	private String appEdDt;  /* 적용종료일자 */
	private int srtOrd;  /* 정렬순서 */
	private String etcDesc;  /* 기타내용 */
	private String useYn;  /* 사용여부 */
	
}


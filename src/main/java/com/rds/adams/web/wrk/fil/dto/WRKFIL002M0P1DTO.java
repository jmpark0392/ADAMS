package com.rds.adams.web.wrk.fil.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 7. 10.
 * @author : BAE BYUNGSUN
 * E-MAIL  : bs.bae@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-07-10 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter
public class WRKFIL002M0P1DTO {
	
	private String tblId;          // 테이블ID
    private String itmNm;          // 칼럼명
    private String itmId;          // 칼럼ID
    private String dataTpCd;       // 데이터타입ID
    private String pkYn;           // PK여부
    private String vlvlVrfYn;      // 유효값검증여부
    private String vlvlCd;         // 유효값코드
    private int ordSeq;            // 정렬순서
    private String itmDsc;         // 항목설명
    private String selBasYn;       // 적재기준여부
    
    private String vrfId;         // 검증ID
    private int seqNo;            // 일련번호
    private String vrfTpCd;       // 검증코드
    private String vrf1LvlCd;     // 검증1레벨코드
    private String vrf2LvlCd;     // 검증2레벨코드
    private String regUsrid;  /* 등록사용자ID */
	private String regDt;  /* 등록일 */
}
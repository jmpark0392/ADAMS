package com.rds.adams.web.WRK.FIL.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 7. 9.
 * @author : BAE BYUNGSUN
 * E-MAIL  : bs.bae@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-07-09 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter
public class WRKFIL002M1R0DTO {
	
    private String itmNm;         // 칼럼명
    private String itmId;         // 칼럼ID
    private String dataTpCd;       // 데이터타입ID
    private String pkYn;           // PK여부
    private String vlvlVrfYn;      // 유효값검증여부
    private String vlvlCd;         // 유효값코드
    private int ordSeq;            // 정렬순서
    private String itmDsc;        // 항목설명
    private String selBasYn;       // 적재기준여부

}
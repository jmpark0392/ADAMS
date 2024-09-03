package com.rds.adams.web.wrk.fil.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 6. 11.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-06-11 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter
public class WRKFIL003M0R0DTO {
	
    private String tblId;
    private String clmnId;
    private String itmNm;
    private String ordSeq;
    private String pkYn;
    private String dataTpCd;
    private String itmDsc;
    private String vlvlVrfYn;
    private String vlvlCd;
    private String selBasYn;
    private String dbId;
    private String uiSelYn;

}
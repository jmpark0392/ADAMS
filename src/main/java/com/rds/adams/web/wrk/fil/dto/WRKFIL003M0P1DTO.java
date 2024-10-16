package com.rds.adams.web.wrk.fil.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 7. 15.
 * @author : LEE CHANGGI
 * E-MAIL  : cg.lee@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-07-15 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter
public class WRKFIL003M0P1DTO {
	
    private int    seqNo;
    private String dbId;
    private String tblId;
    private String fileNm;
    private int    loadCnt;
    private String loadSuccYn;
    private String stdYm;
    private String csNo;

}
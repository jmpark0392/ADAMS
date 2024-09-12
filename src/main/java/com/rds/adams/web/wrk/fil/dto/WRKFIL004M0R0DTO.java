package com.rds.adams.web.wrk.fil.dto;

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
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter
public class WRKFIL004M0R0DTO {
	
	private int seqNo;
    private String fileNm;
    private String tblId;
    private int loadCnt;
    private String stdYm;
    
    @Schema(description = "최초등록사원번호")
	private String frstRegEmpNo;
    
    private String loadStDt;
    private String loadEdDt;
    private String loadSuccYn;

}

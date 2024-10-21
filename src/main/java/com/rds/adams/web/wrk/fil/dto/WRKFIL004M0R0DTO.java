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
@Schema(description = "적재이력 조회 결과 DTO")
@ToString
@Getter
@Setter
public class WRKFIL004M0R0DTO {
	
	@Schema(description = "순번")
	private int seqNo;
	
	@Schema(description = "파일명")
	private String fileNm;
	
	@Schema(description = "테이블ID")
	private String tblId;
	
	@Schema(description = "적재건수")
	private int loadCnt;
	
	@Schema(description = "기준년월")
	private String stdYymm;
	
	@Schema(description = "적재시작일시")
	private String loadStrDt;
	
	@Schema(description = "적재종료일시")
	private String loadEndDt;
	
	@Schema(description = "적재성공여부")
	private String loadSuccYn;

	@Schema(description = "최초등록사원번호")
	private String frstRegEmpNo;

}

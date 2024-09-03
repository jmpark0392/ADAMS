package com.rds.adams.web.wrk.fil.dto;

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
public class WRKFIL001M0R0DTO {
	
	private int seqNo;
	private String fileNm;
	private String dbId;
	private String tblId;
	private String fileDsc;
	private String fileDelYn;
	private String uiSelYn;
	private String useYn;
	private String vrfUseYn;
	private String regUsrid;
	private String regDt;

}
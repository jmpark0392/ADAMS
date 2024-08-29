package com.rds.adams.web.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 6. 10.
 * @author : BAE BYUNGSUN
 * E-MAIL  : bs.bae@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-06-10 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter
public class UplFileDto {
	
	private String seqNo;
	private String fileNm;
	private String dbId;
	private String tblId;
	private String fileDsc;
	private String fileDelYn;
	private String uiSelYn;
	private String useYn;
	private String vrfUseYn;
	private String regUserid;
	private String regDt;

}
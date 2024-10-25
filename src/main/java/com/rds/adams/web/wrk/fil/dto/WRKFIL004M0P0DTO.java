package com.rds.adams.web.wrk.fil.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 7. 16.
 * @author : BAE BYUNGSUN
 * E-MAIL  : bs.bae@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-07-16 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter
public class WRKFIL004M0P0DTO {
	
	@Schema(description = "고객사번호")
	private String csNo;
	
	private int uploadFile;
	private String startLoadDate;
	private String endLoadDate;
	private String startStdYymm;
	private String endStdYymm;

}
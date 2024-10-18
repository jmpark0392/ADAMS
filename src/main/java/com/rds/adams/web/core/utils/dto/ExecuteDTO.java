/**
 * 
 */
package com.rds.adams.web.core.utils.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author JeongHyunseung
 *
 */
@Schema(description = "실행 공통 DTO")
@ToString
@Getter
@Setter
public class ExecuteDTO {
	
	@Schema(description = "기준년월")
	private String stdYymm;
	
	@Schema(description = "등록자ID")
	private String usrId;
	
	@Schema(description = "고객사번호")
	private String csNo;
	
	@Schema(description = "고객사번호")
	private int seqNo;
}
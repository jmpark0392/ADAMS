package com.rds.adams.web.opn.srv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 10. 11.
 * @author : Sardor Madaminov
 * E-MAIL  : sardor@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-10-11 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */

@Schema(description = "옵션 정보 조회 결과 DTO")
@ToString
@Getter
@Setter

public class OPNSRV003M0R0DTO {
    
    @Schema(description = "년월일")
    private int ymd;                           

    @Schema(description = "basic_cnt")
    private int basicCnt;

    @Schema(description = "premium_cnt")
    private int premiumCnt;

    @Schema(description = "user average")
    private int userAvg;

    @Schema(description = "servuice_cost_sum")
    private int srvcCostSum;

    @Schema(description = "service_cost_exepcted_sum")
    private int srvcCostExpSum;
 
}

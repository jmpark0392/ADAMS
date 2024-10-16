package com.rds.adams.web.opn.srv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString; 
import lombok.Getter;
import lombok.Setter;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 10. 16.
 * @author : Sardor Madaminov
 * E-MAIL  : sardor@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-10-16 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
*/

@Schema(description = "option managment grid result DTO")
@ToString
@Getter
@Setter

public class OPNSRV003M0R1DTO {

    @Schema(description = "customer_id")
    private int csNo;

    @Schema(description = "company_name")
    private String compNm;

    @Schema(description = "group_name")     
    private int grp;

    @Schema(description = "service_code")
    private int srvcCd;

    @Schema(description = "service_name")
    private String srvcNm;

    @Schema(description = "day_count")
    private int dayCnt;

    @Schema(description = "service_cos_sum")
    private int srvcCostSum;

    @Schema(description = "service_cost_total")
    private int srvcCostTotal;

    @Schema(description = "service_cost_expected_total")
    private int srvcCostExpTotal;
}

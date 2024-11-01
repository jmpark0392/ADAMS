package com.rds.adams.web.adm.srv.dto;

import java.math.BigDecimal;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 30. 12.
 * @author : Sardor Madaminov
 * E-MAIL  : sardor@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-30-09 : 최초 등록
 * 2024-30-09 : 코드 수정
 * ----------------------------------------------------------
 * </PRE>
 */
@ToString
@Getter
@Setter

public class ADMSRV002M0R0DTO {
    private String ymd;
    private String srvcCd;
    private String srvcCdExp;
    private BigDecimal bSrvcVal;
    private BigDecimal pSrvcVal;
    private BigDecimal srvcCost;
    private BigDecimal srvcCostExp;
    private BigDecimal srvcCostSum;
    private BigDecimal srvcCostExpSum;
    private BigDecimal maxSrvcCostSum;
    private BigDecimal maxSrvcCostExpSum;

    private BigDecimal fileSize;
    private BigDecimal jobTime;
    private BigDecimal maxFileSizeSum;
    private BigDecimal maxJobTimeSum;
    private BigDecimal maxFileCostSum;
    private BigDecimal maxJobCostExpSum;
}

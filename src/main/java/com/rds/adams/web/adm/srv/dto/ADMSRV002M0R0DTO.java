package com.rds.adams.web.adm.srv.dto;

import com.ibm.icu.math.BigDecimal;

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
    private int bSrvcVal;
    private int pSrvcVal;
    private int srvcCost;
    private int srvcCostExp;
    private int srvcCostSum;
    private int srvcCostExpSum;
    private int maxSrvcCostSum;
    private int maxSrvcCostExpSum;
}

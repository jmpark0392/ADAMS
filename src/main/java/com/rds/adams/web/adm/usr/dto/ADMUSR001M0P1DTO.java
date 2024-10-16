package com.rds.adams.web.adm.usr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RDS STANDARD DEVELOP FRAMEWORK
 *
 * @since  : 2024. 10. 10.
 * @author : PARK JUNMIN
 * E-MAIL  : jm.park@rnadatasystem.com
 * <PRE>
 * 개정이력
 * ----------------------------------------------------------
 * 2024-10-10 : 최초 등록
 * ----------------------------------------------------------
 * </PRE>
 */
@Schema(description = "고객사 정보 업데이트 조건 DTO")
@ToString
@Getter
@Setter
public class ADMUSR001M0P1DTO {

    private String companyName;
    private String companyDivision;
    private String companyNo;
    private String countryName;
    private String basicAddress;
    private String detailedAddress;
    private String postalCode;
    private String representativeName;
    private String representativePhone;
    private String useStartDatetime;
    private String userregdatetime;
    
    @Schema(description = "고객사번호")
    private String csNo;


}
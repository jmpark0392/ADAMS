package com.rds.adams.web.adm.srv.dao;

import java.util.List;

import com.rds.adams.web.adm.srv.dto.ADMSRV002M0P0DTO;
import com.rds.adams.web.adm.srv.dto.ADMSRV002M0R0DTO;

public interface ADMSRV002M0DAO {
    List <ADMSRV002M0R0DTO> fetchUserUsageDataAndCost(ADMSRV002M0P0DTO inputDto);
}
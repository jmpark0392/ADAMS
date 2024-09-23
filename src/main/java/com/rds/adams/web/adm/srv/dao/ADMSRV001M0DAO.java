package com.rds.adams.web.adm.srv.dao;

import java.util.List;

import com.rds.adams.web.adm.srv.dto.ADMSRV001M0P0DTO;
import com.rds.adams.web.adm.srv.dto.ADMSRV001M0P1DTO;
import com.rds.adams.web.adm.srv.dto.ADMSRV001M0P2DTO;
import com.rds.adams.web.adm.srv.dto.ADMSRV001M0R0DTO;

public interface ADMSRV001M0DAO {
      List<ADMSRV001M0R0DTO> selectSubscriptionList(ADMSRV001M0P0DTO inVo);
      
      List<ADMSRV001M0P2DTO> selectAllOptions();

      List<ADMSRV001M0R0DTO> selectOptionInfoByCustomer(ADMSRV001M0P0DTO inVo);

      // List<ADMSRV001M0R0DTO> getUserSubscriptionInfo(ADMSRV001M0P0DTO inVo);

      void mergeServiceOption(ADMSRV001M0P1DTO inVo);

      void updateCustomerServiceHistory(ADMSRV001M0P1DTO inVo);

      void updateCustomerOptionHistory(ADMSRV001M0P1DTO inVo);

}

package com.rds.adams.web.adm.srv.controller;

import org.hsqldb.lib.HashMap;
import org.hsqldb.lib.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.rds.adams.web.adm.srv.dto.ADMSRV001M0P0DTO;
import com.rds.adams.web.adm.srv.dto.ADMSRV001M0P1DTO;
import com.rds.adams.web.adm.srv.dto.ADMSRV001M0P2DTO;
import com.rds.adams.web.adm.srv.dto.ADMSRV001M0R0DTO;
import com.rds.adams.web.adm.srv.service.ADMSRV001M0Service;
import com.rds.adams.web.common.login.dto.AdamsLoginDTO;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class ADMSRV001MController {

    @Autowired
    private ADMSRV001M0Service admSrv001M0Service;

    /**
     * Retrieves a list of subscription options available to customers
     * @param inVo
     * @return Map containing the options and the subscription info
     */
     @RequestMapping(value="/ADMSRV001SelectSubcriptionList", method=RequestMethod.GET) 
     public ResponseEntity<Map<String, Object>>loadSubcriptionPage(HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        try {
            // get the user information from session
            AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute("LoginVO");
            if(sAdamsLoginDTO == null){
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("message", "User not logged in");
                return ResponseEntity.status(401).body(errorResponse);
            }

          
            String csNo = sAdamsLoginDTO.getCsNo();

            // fetch the all options;
            List<ADMSRV001M0P2DTO> options = admSrv001M0Service.selectAllOptions();

            // fetch the user's content subscription info
            ADMSRV001M0P0DTO inVo = new ADMSRV001M0P0DTO();
            inVo.setCsNo(csNo);
            List<ADMSRV001M0R0DTO> subscriptionInfo = admSrv001M0Service.selectOptionInfoByCustomer(inVo);

            response.put("options", options);
            response.put("subscriptionInfo", subscriptionInfo);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "User not logged in");
            return ResponseEntity.status(401).body(errorResponse);
        }
     }

     /**
     * Retrieves a all the options
     * @return list of the options 
     */
    @RequestMapping(value="/ADMSRV001M0SelectAllOptions", method=RequestMethod.GET) 
    public ResponseEntity <List<ADMSRV001M0P2DTO>> selectAllOptions() {
        try {
            List<ADMSRV001M0P2DTO> result = admSrv001M0Service.selectAllOptions();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.emptyList());
        }
    }

    /**
     *  Inserts a new service option or updates an existing one for a customer.
     * @param inVo
     * @return  
     */
     @RequestMapping(
         value="/ADMSRV001M0MergeServiceOption",
         method=RequestMethod.POST, 
         consumes = "application/json",  
         produces = "application/json"
    )
     public ResponseEntity<Map<String, Object>> mergeServiceOption(@RequestBody ADMSRV001M0P1DTO inVo, HttpServletRequest request){
        Map<String, Object> response = new HashMap<>();
        try {

            // get the user info from the session 
            AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute("LoginVO");
            if(sAdamsLoginDTO == null){
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("message", "User not logged in");
                return ResponseEntity.status(401).body(errorResponse);
            }

            String csNo = sAdamsLoginDTO.getCsNo();

            // set the necessarry fileds
            inVo.setCsNo(csNo);
            inVo.setFnlUpdEmpNo(csNo);
            inVo.setFrstRegEmpNo(csNo);

            // udpate the service history
            admSrv001M0Service.updateCustomerServiceHistory(inVo);

            // update the option history if needed
            if(inVo.getOptCd() != null && inVo.getOptDtlsCd() != null) {
                admSrv001M0Service.updateCustomerOptionHistory(inVo);
            }

            response.put("status", "success");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("Error merging service option", e);
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
     }

     /**
      *  Updates the service history for a customer, effectively recording changes over time.
      * @param inVo
      * @return 
      */
      @RequestMapping(value="ADMSRV001M0UpdateCustomerServiceHistory", method=RequestMethod.POST, consumes = "application/json")
      public void updateCustomerServiceHistory(@RequestBody ADMSRV001M0P1DTO inVo){
        log.info(inVo.toString());

        admSrv001M0Service.updateCustomerServiceHistory(inVo);
      }

      /**
       * Updates the option history for a customer, tracking changes to their options
       * @param inVo
       * @return 
       */
      @RequestMapping(value="/ADMSRV001M0UpdateCustomerOptionHistory", method = RequestMethod.POST, consumes = "application/json")
      public @ResponseBody Map<String, Object> updateCustomerOptionHistory(@RequestBody ADMSRV001M0P1DTO inVo) {

        log.info(inVo.toString());
    
        admSrv001M0Service.updateCustomerOptionHistory(inVo);
        
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
      }

  /**
   * Fetches the user's current suncsription info.
   * @param reuest HttpServletRequest to get session information.
   * @return User's subscription info.
   */

@GetMapping("/getUserSubscriptionInfo")
public ResponseEntity<List<ADMSRV001M0R0DTO>> getUserSubscriptionInfo(HttpServletRequest request) {
    try {
        // get the user info from the session
        AdamsLoginDTO sAdamsLoginDTO = (AdamsLoginDTO) request.getSession().getAttribute("LoginVO");
        if(sAdamsLoginDTO == null){
            return ResponseEntity.status(401).build();
        }
    
        String csNo = sAdamsLoginDTO.getCsNo();

        ADMSRV001M0P0DTO inVo = new ADMSRV001M0P0DTO();
        inVo.setCsNo(csNo);
        // 
        List<ADMSRV001M0R0DTO> subscriptionInfo = admSrv001M0Service.selectOptionInfoByCustomer(inVo);
        return ResponseEntity.ok(subscriptionInfo);

    } catch (Exception e) {
        e.getStackTrace();
    }
        return ResponseEntity.status(500).build();
    }
}



    // /**
    //  * Retrieves option information specific to a particular customer.
    //  * @param inVo
    //  * @return List of option information by customer
    //  */
    // @RequestMapping(value="/ADMSRV001M0SelectOptionInfoByCustomer", method=RequestMethod.POST, consumes = "application/json")
    // public ResponseEntity<List <ADMSRV001M0R0DTO>> selectOptionInfoByCustomer(@RequestBody ADMSRV001M0P0DTO inVo) {
    //     try {
    //         log.info(inVo.toString());
    //         List<ADMSRV001M0R0DTO> result = admSrv001M0Service.selectOptionInfoByCustomer(inVo);

    //         for (ADMSRV001M0R0DTO dto: result) {
    //             log.info(dto.toString());
    //         }
    
    //         return ResponseEntity.ok(result);
    //     } catch (Exception e){
    //         e.getStackTrace();
    //         return ResponseEntity.status(500).body(Collections.emptyList());
    //     }
    // }
package org.customer.service.controller;


import org.customer.service.model.UtilityMaster;
import org.customer.service.service.UtilityMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utility")
public class UtilityMasterController {

    @Autowired
    UtilityMasterService utilityMasterService;

    @PostMapping("/createUtility")
    public void createUtilityMaster(@RequestBody UtilityMaster utilityMaster) {
        utilityMasterService.saveUtility(utilityMaster);

    }
}

package org.customer.service.controller;


import org.customer.service.model.LocalMaster;
import org.customer.service.service.LocalMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/local")
public class LocalMasterController {

    @Autowired
    LocalMasterService localMasterService;

    @PostMapping("/createLocal")
    public void createLoacalMaster(@Validated @RequestBody LocalMaster localMaster){
        localMasterService.saveLocalMaster(localMaster);

    }
}

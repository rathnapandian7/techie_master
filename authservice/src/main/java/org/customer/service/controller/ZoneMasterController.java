package org.customer.service.controller;


import org.customer.service.model.ZoneMaster;
import org.customer.service.service.ZoneMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zone")
public class ZoneMasterController {

    @Autowired
    ZoneMasterService zoneMasterService;

    @PostMapping("/createZone")
    public void createZone(@RequestBody ZoneMaster zoneMaster) {
        zoneMasterService.saveZoneMaster(zoneMaster);


    }
}

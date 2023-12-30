package org.customer.service.controller;


import org.customer.service.model.SiteMaster;
import org.customer.service.service.SiteMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/site")
public class SiteMasterController {
    @Autowired
    SiteMasterService siteMasterService;

    @PostMapping("/createSite")
    public void createSiteMaster(@RequestBody SiteMaster siteMasterRequest) {
        siteMasterService.createSiteMaster(siteMasterRequest);
    }
}

package org.customer.service.controller;

import org.customer.service.model.CountryMaster;
import org.customer.service.service.CountryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryMasterController {

    @Autowired
    CountryMasterService countryMasterService;

    @PostMapping("/createCountry")
    public void createCountry(@RequestBody CountryMaster countryMaster) {
        countryMasterService.saveCountry(countryMaster);
    }
}

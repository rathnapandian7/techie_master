package org.customer.service.controller;


import org.customer.service.model.Citymaster;
import org.customer.service.service.CityMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityMasterController {

    @Autowired
    CityMasterService cityMasterService;

    @PostMapping("/createCity")
    public void createCityMater(@RequestBody Citymaster citymaster) {
        cityMasterService.saveCityMaster(citymaster);
    }

}

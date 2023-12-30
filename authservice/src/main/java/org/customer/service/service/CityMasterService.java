package org.customer.service.service;

import org.customer.service.model.Citymaster;
import org.customer.service.repository.CityMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityMasterService {

    @Autowired
    CityMasterRepository cityMasterRepository;

    public void saveCityMaster(Citymaster citymaster){
        cityMasterRepository.save(citymaster);
    }
}

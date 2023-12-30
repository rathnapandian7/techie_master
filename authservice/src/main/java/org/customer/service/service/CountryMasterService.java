package org.customer.service.service;

import org.customer.service.model.CountryMaster;
import org.customer.service.repository.CountryMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryMasterService {

    @Autowired
    CountryMasterRepository countryMasterRepository;

    public void saveCountry(CountryMaster countryMaster) {
        countryMasterRepository.save(countryMaster);
    }
}

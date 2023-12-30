package org.customer.service.service;


import org.customer.service.model.SiteMaster;
import org.customer.service.repository.SiteMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteMasterService {

    @Autowired
    SiteMasterRepository siteMasterRepository;

    public void createSiteMaster(SiteMaster siteMaster) {
        siteMasterRepository.save(siteMaster);

    }

}

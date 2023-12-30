package org.customer.service.service;

import org.customer.service.model.ZoneMaster;
import org.customer.service.repository.ZoneMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneMasterService {

    @Autowired
    ZoneMasterRepository zoneMasterRepository;

    public void saveZoneMaster(ZoneMaster zoneMaster) {
        zoneMasterRepository.save(zoneMaster);
    }
}

package org.customer.service.service;


import org.customer.service.model.UtilityMaster;
import org.customer.service.repository.UtilityMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityMasterService {

    @Autowired
    UtilityMasterRepository utilityMasterRepository;

    public void saveUtility(UtilityMaster utilityMaster) {
        utilityMasterRepository.save(utilityMaster);
    }
}

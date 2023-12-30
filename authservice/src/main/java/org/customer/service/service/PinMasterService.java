package org.customer.service.service;


import org.customer.service.model.PinMaster;
import org.customer.service.repository.PinMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PinMasterService {


    @Autowired
    PinMasterRepository pinMasterRepository;

    public void savePinMaster(PinMaster pinMaster){
        pinMasterRepository.save(pinMaster);

    }
}

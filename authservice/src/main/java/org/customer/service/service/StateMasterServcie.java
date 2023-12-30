package org.customer.service.service;


import org.customer.service.model.StateMaster;
import org.customer.service.repository.StateMasterRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateMasterServcie {
    @Autowired
    StateMasterRespository stateMasterRespository;

    public void saveStateMaster(StateMaster stateMaster) {
        stateMasterRespository.save(stateMaster);
    }
}

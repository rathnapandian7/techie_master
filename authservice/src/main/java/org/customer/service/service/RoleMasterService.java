package org.customer.service.service;


import org.customer.service.model.RoleMaster;
import org.customer.service.repository.RoleMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleMasterService {

    @Autowired
    RoleMasterRepository roleMasterRepository;


    public void createRoleMaster(RoleMaster roleMaster){
        roleMasterRepository.save(roleMaster);
    }
}

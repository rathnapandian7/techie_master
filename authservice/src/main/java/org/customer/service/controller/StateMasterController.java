package org.customer.service.controller;


import org.customer.service.model.StateMaster;
import org.customer.service.service.StateMasterServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state")
public class StateMasterController {

    @Autowired
    StateMasterServcie stateMasterServcie;

    @PostMapping("/createState")
    public void createState(StateMaster stateMaster) {
        stateMasterServcie.saveStateMaster(stateMaster);
    }

}

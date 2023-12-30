package org.customer.service.controller;

import org.customer.service.model.RoleMaster;
import org.customer.service.service.RoleMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleMasterService roleMasterService;


    @PostMapping("/createRole")
    private void createRoleMaster(@RequestBody RoleMaster roleMaster) {
        roleMasterService.createRoleMaster(roleMaster);

    }

}

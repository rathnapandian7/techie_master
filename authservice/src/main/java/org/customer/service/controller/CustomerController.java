package org.customer.service.controller;

import org.customer.service.dto.CustomerDetailsDto;
import org.customer.service.model.CustomerDetailsModel;
import org.customer.service.response.Response;
import org.customer.service.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    public static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService service;


    @GetMapping("/getCustomer")
    public Response<CustomerDetailsDto> getCustomerDetails(@RequestParam Long custId) throws Exception {
        return service.getCustomerDetails(custId);
    }


    @PostMapping("/create")
    public Response createCustomer(@RequestBody CustomerDetailsModel customerDetailsModel) throws Exception {
        return service.createCustomer(customerDetailsModel);


    }
}

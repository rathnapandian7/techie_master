package org.customer.service.service;


import org.customer.service.dto.CustomerDetailsDto;
import org.customer.service.exception.CustomerCreationException;
import org.customer.service.model.CustomerDetailsModel;
import org.customer.service.model.UserDetailsModel;
import org.customer.service.repository.CustomerDetailsRespository;
import org.customer.service.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    CustomerDetailsRespository repo;

    public Response<CustomerDetailsDto> getCustomerDetails(Long custId) {
        Response<CustomerDetailsDto> response = new Response<>();
        CustomerDetailsDto customerDto = new CustomerDetailsDto();
        log.info("get customer details for customerId " + custId);
        try {
            Optional<CustomerDetailsModel> customerDetailsModel = repo.findById(custId);
            if (customerDetailsModel.isPresent()) {
                customerDto.setCustomerName(customerDetailsModel.get().getCustomerName());
                response.setData(customerDto);
                response.setStatus(HttpStatus.OK.value());
                log.info(" customer details Created successfully{}");
            } else {
                response.setMessage("User Not available");
                response.setStatus(HttpStatus.OK.value());
            }
        } catch (Exception e) {
            log.error("customer details creation failed due to{}" + e.getCause());
            throw new CustomerCreationException("can't able to create customer due to " + e.getMessage());
        }

        return response;

    }

    public Response createCustomer(CustomerDetailsModel customerDetailsModel) {
        try {
            int nextVal = repo.getCustomerSequence();
            customerDetailsModel.setPrefixCUstomerId("C-" + String.valueOf(nextVal));
            UserDetailsModel service = new UserDetailsModel();
            service.setCustomerId(customerDetailsModel.getId());
//            service.setCustomerId(Long.valueOf(nextVal));
            service.setContCode("123");
            customerDetailsModel.setCustomerDetailsModelList(Arrays.asList(service));
            repo.save(customerDetailsModel);
            Response response = new Response<>();
            response.setMessage("customer detail created successfully");
            response.setStatus(HttpStatus.OK.value());
            log.info("customer detail created successfully");
            return response;
        } catch (Exception e) {
            log.error("customer creation failed due to " + e.getCause());
        }
        return null;
    }


}

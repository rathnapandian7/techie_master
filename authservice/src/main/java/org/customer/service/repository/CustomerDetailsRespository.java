package org.customer.service.repository;

import org.customer.service.model.CustomerDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRespository extends JpaRepository<CustomerDetailsModel, Long> {


    @Query(value = "select next_val from CUSTOMER_SEQUENCE", nativeQuery = true)
    int getCustomerSequence();
}

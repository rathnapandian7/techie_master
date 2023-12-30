package org.customer.service.repository;


import org.customer.service.model.PinMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinMasterRepository extends JpaRepository<PinMaster,Long> {

}

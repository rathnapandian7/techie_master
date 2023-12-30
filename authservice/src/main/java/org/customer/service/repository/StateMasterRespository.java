package org.customer.service.repository;


import org.customer.service.model.StateMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateMasterRespository extends JpaRepository<StateMaster,Long> {


}

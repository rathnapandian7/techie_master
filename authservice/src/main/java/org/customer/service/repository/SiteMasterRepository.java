package org.customer.service.repository;


import org.customer.service.model.SiteMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteMasterRepository extends JpaRepository<SiteMaster, Long> {


}

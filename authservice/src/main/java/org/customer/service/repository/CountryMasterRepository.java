package org.customer.service.repository;

import org.customer.service.model.CountryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryMasterRepository extends JpaRepository<CountryMaster,Long> {
}

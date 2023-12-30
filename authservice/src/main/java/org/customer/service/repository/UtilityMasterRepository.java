package org.customer.service.repository;

import org.customer.service.model.UtilityMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityMasterRepository extends JpaRepository<UtilityMaster,Long> {
}

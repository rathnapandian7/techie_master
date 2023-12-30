package org.customer.service.repository;


import org.customer.service.model.ZoneMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneMasterRepository extends JpaRepository<ZoneMaster,Long> {
}

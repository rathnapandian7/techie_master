package org.example.dao;

import org.example.entity.CustomerEntity;
import org.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    public Optional<CustomerEntity> findByUserName(String username);

//    public UserEntity findByUserName(String name);
}

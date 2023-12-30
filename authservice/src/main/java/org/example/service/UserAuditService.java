package org.example.service;


import org.example.dao.UserAuditRepository;
import org.example.entity.UserAuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuditService {


    @Autowired
    UserAuditRepository userAuditRepo;


    public void saveUserAudit(UserAuditEntity userAuditEntity) {
        userAuditRepo.save(userAuditEntity);
    }

    public int getUserAuditCount(Integer userId) {
        return userAuditRepo.getUserAuditCount(userId);
    }

    public void deleteUserAudit(Integer userId) {
        userAuditRepo.deleteUserAudit(userId);
    }
}

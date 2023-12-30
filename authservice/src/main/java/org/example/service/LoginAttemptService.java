package org.example.service;


import org.example.dao.UserRepository;
import org.example.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginAttemptService {

    @Autowired
    UserRepository userRepository;


    public boolean isBlocked(final String key) {
        Optional<UserEntity> optionalUser = userRepository.findByUserName(key);
        if(optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            return "B".equals(user.getStatus());
        }
        return false;
    }
}

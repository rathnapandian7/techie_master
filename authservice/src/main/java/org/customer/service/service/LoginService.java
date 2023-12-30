package org.customer.service.service;

import org.customer.service.entity.ResponseModel;
import org.customer.service.entity.TokenDetailEntity;
import org.customer.service.entity.UserAuditEntity;
import org.customer.service.entity.UserEntity;
import org.customer.service.utils.Constants;
import org.customer.service.repository.TokenDetailRepository;
import org.customer.service.repository.UserInformation;
import org.customer.service.repository.UserRepository;
import org.customer.service.exception.BadDataExceptionHandler;
import org.customer.service.security.dao.LoginDao;
import org.customer.service.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;

    @Value("${security.jwt.access.token.validity}")
    private Integer tokenExpiryTime;

    @Autowired
    TokenDetailRepository tokenRepo;
    @Autowired
    TokenValidation tokenValidation;

    @Autowired
    GenerateToken generateToken;

    @Autowired
    UserAuditService userAuditService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<UserInformation> customerlogin(LoginDao login) {
        ResponseModel response = new ResponseModel();
        Optional<UserEntity> userDetailOptional = userRepository.findByUserName(login.getUserName());
        if (!userDetailOptional.isPresent() || null == userDetailOptional.get().getUserName()) {
            response.setMessage(Constants.USER_NOT_AVAIL);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        } else {
            UserEntity userDetail = userDetailOptional.get();
            if (!"B".equals(userDetail.getStatus())) {
                if (decodeToken(userDetail.getPassword(), login.getPassword())) {
                    userAuditService.deleteUserAudit(userDetail.getUserId());
                    UserInformation userInformation = new UserInformation();
                    addUserTokenDetails(userInformation, userDetail, login.getIsRememberMe(), login);
                    userInformation.setUserId(userDetail.getUserId());
                    userInformation.setUpdatedBy(userDetail.getUserId());
                    userInformation.setLastLoggedIn(LocalDateTime.now());
                    userDetail.setLastLoggedIn(LocalDateTime.now());
                    userRepository.save(userDetail);
                    return new ResponseEntity(userInformation, HttpStatus.OK);
                } else {
                    logUserDetails(userDetail);
                    int invalidLoginAttemptCount = userAuditService.getUserAuditCount(userDetail.getUserId());
                    if (invalidLoginAttemptCount >= Constants.MAX_INVALID_LOGIN_ATTEMPT_COUNT) {
                        try {
                            userRepository.blockUser(userDetail.getUserName());
                            throw new BadDataExceptionHandler(Constants.USER_BLOCKED);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    int attemptLeft = Constants.MAX_INVALID_LOGIN_ATTEMPT_COUNT - invalidLoginAttemptCount;
                    if (attemptLeft > 0) {
                        throw new BadDataExceptionHandler(Constants.PASSWORDS_DONT_MATCH_ERROR + attemptLeft);
                    } else {
                        throw new BadDataExceptionHandler(Constants.PASSWORD_ATTEMPTS_EXCEEDED);
                    }

                }
            } else {
                response.setMessage(Constants.USER_BLOCKED);
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        }

    }

    private boolean decodeToken(String userpassword, String loginpwd) {
        return bCryptPasswordEncoder.matches(loginpwd, userpassword);
    }


    @Transactional
    private void addUserTokenDetails(UserInformation userInformation, UserEntity userDetail, Integer isRemeberToken,
                                     LoginDao login) {
        TokenDetailEntity tokenDetail = new TokenDetailEntity();
        tokenDetail.setClientIp("");
        tokenDetail.setDevicetype("");
        tokenDetail.setUserId(userDetail.getUserId());
        tokenDetail.setTokenExpiryTime(LocalDateTime.now().plusMinutes(tokenExpiryTime));
        tokenDetail.setIsRemember(isRemeberToken);
        tokenDetail.setCreadtedBy("System");
        tokenDetail.setUpdatedBy("System");
        tokenDetail.setUpdatedDate(Util.getCurrentDateTime());
        tokenDetail.setCreadtedDate(Util.getCurrentDateTime());
        generateToken.generateToken(tokenDetail, login, userDetail.getUserId());
        tokenRepo.save(tokenDetail);
        userInformation.setUserId(userDetail.getUserId());
        userInformation.setUserName(userDetail.getUserName());
        userInformation.setCreadtedDate(userDetail.getCreadtedDate());
        userInformation.setUpdatedBy(userDetail.getUpdatedBy());
        userInformation.setToken(tokenDetail.getToken());
        userInformation.setRefreshToken(tokenDetail.getRefreshToken());
        userInformation.setUpdatedDate(LocalDateTime.now());
        userInformation.setCreadtedBy(tokenDetail.getUserId());
        userInformation.setFirstName(userDetail.getFirstName());
        userInformation.setLastName(userDetail.getLastName());
    }

    public ResponseEntity<ResponseModel> signOut(String token) {
        ResponseModel response = new ResponseModel();
        Integer userId = tokenValidation.validateToken(token);
        response.setMessage(Constants.LOG_OUT_SUCCESS);
        response.setStatus(HttpStatus.OK.value());
        tokenRepo.deleteTokenById(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void logUserDetails(UserEntity userDetail) {
        UserAuditEntity userAudit = new UserAuditEntity();
        userAudit.setUserId(userDetail.getUserId());
        userAudit.setCreatedBy(userDetail.getUserName());
        userAudit.setUpdatedBy(userDetail.getUserName());
        userAudit.setUpdatedDate(Util.getCurrentDateTime());
        userAudit.setCreatedDate(Util.getCurrentDateTime());
        userAuditService.saveUserAudit(userAudit);
    }


}




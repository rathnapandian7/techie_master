package org.example.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class UserInformation {

    private Integer userId;

    private String firstName;

    private String lastName;

    private String userName;

    private Integer creadtedBy;

    private String token;

    private String refreshToken;

    private LocalDateTime creadtedDate;

    private LocalDateTime lastLoggedIn;

    private Integer updatedBy;

    private LocalDateTime updatedDate;
}

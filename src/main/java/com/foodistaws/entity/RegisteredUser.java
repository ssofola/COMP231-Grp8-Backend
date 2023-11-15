package com.foodistaws.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TODO: Add Bean validation to ensure you only store valid records
 */
@Document(collection = "registeredUser")
@Data
public class RegisteredUser {
    @Id
    private String userID;
    private String fullName;
    private String email;
    private String userName;
    private String passwd;
    private String roleID;
    @Transient
    private Role role;
}

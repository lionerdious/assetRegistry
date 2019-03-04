package com.springboot.users.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class users {
    private String userId;
    private String userName;
    private String gender;
    private Boolean married;
    private String profile;
}

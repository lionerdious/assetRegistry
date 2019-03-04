package com.springboot.users.Entity;

import com.springboot.init.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class users extends BaseEntity {
    private String userId;
    private String userName;
    private String gender;
    private Boolean married;
    private String profile;
}

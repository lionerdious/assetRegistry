/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.init.repository;

import com.springboot.init.userModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kudakwashe
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByEmail(String email); 
}

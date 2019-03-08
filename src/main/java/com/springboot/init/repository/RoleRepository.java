/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.init.repository;

import com.springboot.init.userModel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kudakwashe
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    Role findByRole(String role);
    
}

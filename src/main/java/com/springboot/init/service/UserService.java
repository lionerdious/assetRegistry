/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.init.service;

import com.springboot.init.userModel.User;

/**
 *
 * @author kudakwashe
 */
public interface UserService {
    
    public User findUserByEmail(String email);
    
    public void saveUser(User user);
    
}

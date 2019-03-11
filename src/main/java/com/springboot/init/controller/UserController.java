/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.init.controller;

import com.springboot.init.service.UserService;
import com.springboot.init.userModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kudakwashe
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView model = new ModelAndView();
        model.setViewName("user/login");
        return model;
    }
    
    @RequestMapping(value={"/", "/signup"}, method = RequestMethod.GET)
    public ModelAndView signup(){
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user)
        
    }
    
}

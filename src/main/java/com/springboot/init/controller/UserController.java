/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.init.controller;

import com.springboot.init.service.UserService;
import com.springboot.init.userModel.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
        model.addObject("user", user);
        model.setViewName("user/signup");
        
        return model;
        
    }
    
    @RequestMapping(value={"/signup"}, method=RequestMethod.POST)
    public ModelAndView reateUser(@Valid User user, BindingResult bindingResult){
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        
        if(userExists != null){
            bindingResult.rejectValue("email", "error.user", "This Email Already Exits");
        }
        if(bindingResult.hasErrors()){
            model.setViewName("user/signup");
        }else{
            userService.saveUser(user);
            model.addObject("msg", "User Has Registered Successfully");
            model.addObject("user", new User());
            model.setViewName("user/signup");
        }
        
        return model;
    }
    
    @RequestMapping(value={"/home/home"}, method=RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        
        model.addObject("userName", user.getFirstname() + " " + user.getLastname());
        model.setViewName("home/home");
        return model;
    }
    
    @RequestMapping(value={"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied(){
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }
    
}

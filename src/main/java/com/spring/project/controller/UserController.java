package com.spring.project.controller;

import com.spring.project.entity.UserDetail;
import com.spring.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @ModelAttribute
    private void userDetails(Model m, Principal p){
        String email = p.getName();
        UserDetail userDetail = userRepository.findByEmail(email);
        m.addAttribute("user",userDetail);
    }

    @GetMapping("/home")
    public String home(){
        return "user/home";
    }

    @GetMapping("/contactUs")
    public String contactUs(){
        return "contactUs";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }
}

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String homePage(){


        return "homepage";
    }

    @RequestMapping("/register")
    public String addUser(){

        return "registerform";
    }

    @RequestMapping("/login")
    public String loginPage(){

        return "loginform";
    }

}

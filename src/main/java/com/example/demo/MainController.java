package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {


    @Autowired
    private UserService userService;

    @Autowired
    MessageRepo messageRepo;

    @RequestMapping("/")
    public String homePage(Model model){


        model.addAttribute("messages", messageRepo.findAll());

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


    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        model.addAttribute("user", user);
        if (result.hasErrors()) {

            return "registerform";
        } else {

            userService.saveUser(user);
            model.addAttribute("message", "User Account Created");
        }
        return "redirect:/";
    }

    @GetMapping("/registerPage")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registerform";
    }
}

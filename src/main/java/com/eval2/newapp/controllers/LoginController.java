package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eval2.newapp.services.LoginService;

@Controller
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
    @GetMapping("/")
    public String login() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(Model model, @RequestParam("usr") String usr, @RequestParam("pwd") String pwd) {
        try {
            ResponseEntity<String> response = loginService.login(usr, pwd);
            return "redirect:/rfq/";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid login. Try again.");
            System.out.println("ERROR MESSAGE : "+e.getMessage());
            e.printStackTrace();
        }

        return "login";
    }
}
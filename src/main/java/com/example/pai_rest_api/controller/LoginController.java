package com.example.pai_rest_api.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, Authentication auth){
        String email = null;
        if(auth != null){
            // dane logowania
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            System.out.println("DANE LOGOWANIA: " + userDetails);
            email = userDetails.getUsername();
        }
        // obiekt do komunikacji z warstwą front-end
        model.addAttribute("email", email);
        return "loginPage";
    }
    @GetMapping("/example")
    public String getExampleView(){
        return "exampleView";
    }
}

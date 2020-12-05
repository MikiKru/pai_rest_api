package com.example.pai_rest_api.controller;


import com.example.pai_rest_api.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
// ALT + Enter -> auto-podpowiedź
// CTRL + D -> Duplikowanie lini
// ALT + Ins -> Generator kodu

// adnotacja determinująca klasę o znaczeniu specjalnym
// @Controller -> mapowanie adresów url wykorzystujące żądania http na wywołania metod -> zwraca widok .html
// @RestController -> mapowanie adresów url wykorzystujące żądania http na wywołania metod -> rest api
@RestController     // klasa zarządzana kontekstem springa
public class RestAPIController {
    @GetMapping("/")                    // localhost:8080/
    public String helloWorld(){
        return "Hello World!";
    }
    @PostMapping("/users/addUser")      // localhost:8080/resurce/functionality
    public User addUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        return new User(0, email, password, LocalDateTime.now(), false);
    }
}

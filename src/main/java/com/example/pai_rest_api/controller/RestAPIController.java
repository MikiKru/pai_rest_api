package com.example.pai_rest_api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// ALT + Enter -> auto-podpowiedź
// CTRL + D -> Duplikowanie lini
// ALT + Ins -> Generator kodu

// adnotacja determinująca klasę o znaczeniu specjalnym
// @Controller -> mapowanie adresów url wykorzystujące żądania http na wywołania metod -> zwraca widok .html
// @RestController -> mapowanie adresów url wykorzystujące żądania http na wywołania metod -> rest api
@RestController     // klasa zarządzana kontekstem springa
public class RestAPIController {
    @GetMapping("/")            // localhost:8080/
    public String helloWorld(){
        return "Hello World!";
    }
}

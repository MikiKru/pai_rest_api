package com.example.pai_rest_api.controller;

import com.example.pai_rest_api.model.User;
import com.example.pai_rest_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public void registerUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        User user = new User(email, password, LocalDateTime.now(), false);
        userService.registerUser(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PutMapping("/users/{userId}")
    public void updateUserStatus(@PathVariable("userId") int userId){
        userService.activateUser(userId);
    }
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") int userId){
        userService.deleteUserById(userId);
    }
}

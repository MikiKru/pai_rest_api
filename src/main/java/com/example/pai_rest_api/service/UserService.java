package com.example.pai_rest_api.service;

import com.example.pai_rest_api.model.User;
import com.example.pai_rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // klasa o znaczeniu specjalnym implementująca logikę biznesową
public class UserService {
    UserRepository userRepository;
    // mechanizm wstrzykiwania zależności - przez konstruktor
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // INSERT
    public void registerUser(User user){
        userRepository.save(user);                  // INSERT INTO user VALUES (?,?,?,?,?);
    }
    // SELECT
    public List<User> getAllUsers(){
        return userRepository.findAll();            // SELECT * FROM user;
    }
    public Optional<User> getUserById(int userId){
        return userRepository.findById(userId);     // SELECT * FROM user WHERE user_id = ?;
    }
    // UPDATE
    public void activateUser(int userId){
        Optional<User> userOptional = getUserById(userId);
        if(userOptional.isPresent()){
            User userToActivate = userOptional.get();
            userToActivate.setStatus(true);         // aktywacja
            userRepository.save(userToActivate);    // UPDATE user SET status = true WHERE user_id = ?;
        }
    }
    // DELETE
    public void deleteUserById(int userId){
        if(userRepository.existsById(userId)){
           userRepository.deleteById(userId);       // DELETE FROM user WHERE user_id = ?;
        }
    }
}

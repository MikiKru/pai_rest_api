package com.example.pai_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
// Model JavaBeans
// -> pola prywatne
// -> publiczne metody dostępowe get/set
// -> konstruktory
// -> toString()
@Entity
@Data                  // dodaje get/set/toString
@NoArgsConstructor     // konstruktor domyślny
@AllArgsConstructor    // konstruktor z wszystkimi polami w argumentach
public class User {
    @Id                 // klucz głowny tabeli user
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto inkrementacja
    private int userId;
    private String email;
    private String password;
    private LocalDateTime registrationTime;
    private boolean status;
    private String role;

    public User(String email, String password, LocalDateTime registrationTime, boolean status, String role) {
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.registrationTime = registrationTime;
        this.status = status;
        this.role = role;
    }
}

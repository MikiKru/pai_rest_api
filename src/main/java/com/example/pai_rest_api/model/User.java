package com.example.pai_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
// Model JavaBeans
// -> pola prywatne
// -> publiczne metody dostępowe get/set
// -> konstruktory
// -> toString()
@Data                  // dodaje get/set/toString
@NoArgsConstructor     // konstruktor domyślny
@AllArgsConstructor    // konstruktor z wszystkimi polami w argumentach
public class User {
    private int userId;
    private String email;
    private String password;
    private LocalDateTime registrationTime;
    private boolean status;
}

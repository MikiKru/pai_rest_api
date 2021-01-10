package com.example.pai_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    private String title;
    @Type(type = "text")
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private LocalDateTime registration_time;
    // REALCJA N : 1
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private User user;
    // REALCJA N : M
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "task_to_category",
            joinColumns = @JoinColumn(name = "task_task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_category_id")
    )
    private Set<Category> categories = new HashSet<>();

}

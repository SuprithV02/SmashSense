package com.smashsense.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // This tells the spring boot(via JPA) that this class is a database entity
@Table(name = "users") // Maps this entity to the table name "users"
@Data // This annotation is from Lombok...where it will have the predefined setters
      // and getters
@NoArgsConstructor // Generates a No-Argument constructor of new User()
@AllArgsConstructor // Generates a constructor with all fields as parameters
@Builder // Allows me to create a User Object
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique = true)
    private String username;

    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}

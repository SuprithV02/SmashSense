package com.smashsense.repository;

import java.util.Optional; //A container that may or may-not contain null values, avoids null pointer exception

import org.springframework.data.jpa.repository.JpaRepository; //This is a interface from Spring Data JPA which has the sql built-in methods
import com.smashsense.model.User;

public interface UserRepository extends JpaRepository<User, Long> { // User is the entity, this repo works with and Long
                                                                    // is the type of the primary key
    // This JpaRepository gives an Out-of-Box CRUD methods
    Optional<User> findByUsername(String username);
    // This is a custom query method , and Spring Data Jpa is smart enough to
    // generate the query automatically
    // This searches the user for the username field, which returns
    // if found - contains the user
    // if not - empty optional(instead of null, which is safer)
}

// UserRepository is a DAO (Data access Object) or repository class, and this
// doesn't need to be a class because
// Spring Boot handles the implementation internally cause we are extending the
// JpaRepository

// NOTE : Extends JpaRepository to get all basic DB methods for free.
// Adds a custom method findByUsername() to find a user by their username.
// Helps you talk to the database without writing SQL manually.

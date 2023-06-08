package com.security.Security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer> {     //to inherit CRUD operations.

    Optional<User> findByEmail(String email);

}

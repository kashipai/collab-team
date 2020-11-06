package com.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByUsername(String username);
}

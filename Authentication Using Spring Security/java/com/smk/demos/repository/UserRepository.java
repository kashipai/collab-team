package com.smk.demos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smk.demos.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);

}

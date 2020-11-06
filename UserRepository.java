package com.example.springSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springSecurity.Model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String> 
{	
	public Users findUsersByUsername(@Param("username") String username);
	
}

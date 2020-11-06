package com.example.springSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springSecurity.Model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>
{

}

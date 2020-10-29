package com.example.libraryRest.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.libraryRest.Model.Library;
import java.util.List;

@Repository
public interface LibraryRepository extends CrudRepository<Library,Integer>
{
	  Library findById(int id); 
	    List<Library> findAll(); 
	    void deleteById(int id);
}

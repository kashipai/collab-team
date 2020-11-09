package com.example.libraryRest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.libraryRest.Model.Library;
import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>
{
	@Query("SELECT l from  Library l WHERE l.author =:author")
	   public Library findByAuthor(@Param("author") String author);
	
	
}

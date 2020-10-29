package com.example.libraryRest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.libraryRest.Dao.LibraryRepository;
import com.example.libraryRest.Model.Library;

@RestController
public class LibraryController
{
	
	    @Autowired
	    private LibraryRepository repo; 
	   
	  
	    // Home Page 
	    @GetMapping("/") 
	    public String welcome() 
	    { 
	        return "<html><body><center>"
	            + "<h1>WELCOME</h1>"
	        		
	            + "</center></body></html>"; 
	    } 
	   
	    @GetMapping("/library") 
	    public List<Library> getAllBooks() 
	    { 
	        return repo.findAll(); 
	    } 
	  
	    @GetMapping("/library/{id}") 
	    public Library getBookById( 
	        @PathVariable(value = "id") int id) 
	    { 
	        return repo.findById(id); 
	    } 
	  
	    @PostMapping("/libAdd") 
	    @ResponseStatus(HttpStatus.CREATED) 
	    public Library addBook( 
	        @RequestBody Library book) 
	    { 
	        return repo.save(book); 
	    } 
	  
	    @DeleteMapping("/delete/{id}") 
	    public void deleteBook( 
	        @PathVariable(value = "id") int id) 
	    { 
	        repo.deleteById(id); 
	    } 
	  
	    @PutMapping("/book/{id}") 
	    public ResponseEntity<Object> updateBook( 
	        @RequestBody Library book, 
	        @PathVariable int id) 
	    { 
	  
	        Optional<Library> libRepo 
	            = Optional.ofNullable( 
	                repo.findById(id)); 
	  
	        if (!libRepo.isPresent()) 
	            return ResponseEntity 
	                .notFound() 
	                .build(); 
	  
	        book.setId(id); 
	  
	        repo.save(book); 
	  
	        return ResponseEntity 
	            .noContent() 
	            .build(); 
	    } 
	
}

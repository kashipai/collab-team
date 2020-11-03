package com.example.libraryRest.Controller;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

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

import com.example.libraryRest.Model.Library;
import com.example.libraryRest.Service.LibraryService;


@RestController
public class LibraryController
{
	
	    @Autowired
	    private LibraryService service; 
	   
	    @GetMapping("/") 
	    public String welcome() 
	    { 
	        return "<html><body><center>"
	            + "<h1>LIBRARY REST API</h1>"
	        	
	            + "</center></body></html>"; 
	    } 
	   
	    @GetMapping("/library") 
	    public List<Library> getAllBooks()
	    { 
	        return service.bookList(); 
	    } 
	  
	    @GetMapping("/library/{id}") 
	    public Library getBookById( 
	        @PathVariable(value = "id") int id) throws NoSuchElementException
	    { 
	        return service.getId(id); 
	    } 
	      
	    @PostMapping("/libAdd") 
	    @ResponseStatus(HttpStatus.CREATED) 
	    public Library addBook( 
	        @RequestBody Library book) 
	    { 
	        return service.addBook(book); 
	    } 
	  
	    @DeleteMapping("/delete/{id}") 
	    public void deleteBook( 
	        @PathVariable(value = "id") int id) throws NoSuchElementException
	    { 
	        service.delete(id); 
	    } 
	  
	    @PutMapping("/book/{id}") 
	    public ResponseEntity<Object> updateBook( 
	        @RequestBody Library book, 
	        @PathVariable int id) throws NoSuchElementException
	    { 
	        Optional<Library> libRepo 
	            = Optional.ofNullable( 
	                service.getId(id)); 
	  
	        if (!libRepo.isPresent()) 
	            return ResponseEntity 
	                .notFound() 
	                .build(); 
	  
	        book.setId(id); 
	  
	        service.addBook(book); 
	  
	        return ResponseEntity 
	            .noContent() 
	            .build(); 
	    } 
	
}

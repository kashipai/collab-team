package com.example.libraryRest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryRest.Model.Library;
import com.example.libraryRest.Dao.LibraryRepository;

import java.util.*;

@Service
public class LibraryService 
{
	@Autowired
	private LibraryRepository repo;
		
		public List<Library> bookList(){
			List<Library> lib = repo.findAll();
			//System.out.println("\nsize:"+lib.size());
			return lib;
		}
		
		public Library addBook(Library book) {
			
			System.out.println("\book-Id:"+book.getId());
			return repo.save(book);
			
		}
		
		public Library getId(Integer id) {
			return repo.findById(id).get();
		}
		
		public void delete(Integer id) {
	       repo.deleteById(id);
		}

}

package com.example.libraryRest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.libraryRest.Dao.LibraryRepository;
import com.example.libraryRest.Model.Library;
import com.example.libraryRest.Service.LibraryService;

@SpringBootTest

class MockitoJunit {

	@Autowired
	private LibraryService service;
	
	@MockBean
	private LibraryRepository repo;
	
	
	@Test
	void getBookstest() {
		when(repo.findAll()).thenReturn(Stream.of(
				new Library(1990092,"Animal Farm","George Orwell",100),
				new Library(1211,"Lost Symbol","Dan Brown",245), 
				new Library(1234,"Vamshavruksha","SLB",320))
				.collect(Collectors.toList()));
		
		assertEquals(3,service.bookList().size());
	}

	@Test
	void getByIdTest()
	{
		int id = 120;
		Library book = new Library(1234,"Vamshavruksha","SLB",320);
		
		when(repo.findById(id).get()).thenReturn(book);
		assertEquals(book, service.getId(id));
		
	}	
	
	@Test
	void saveTest()
	{
		Library lib = new Library(12121,"Lost Symbol","Dan Brown",245);
		when(repo.save(lib)).thenReturn(lib);
		
		assertEquals(lib, service.addBook(lib));
		
		service.addBook(lib);
		verify(repo, times(2)).save(lib);
		
	}
	
	@Test
	void deleteTest()
	{
		service.delete(1234);
		verify(repo, times(1)).deleteById(1234);
	}

}


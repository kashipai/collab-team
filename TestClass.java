package jpa_oneToOne;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		AuthorService authorService = (AuthorService) appContext.getBean(AuthorService.class);
		
		authorService.saveBookEntry(new Book(101,"To Kill A Mockingbird",new Author(1,"Harper", "Lee")));
		authorService.saveBookEntry(new Book(102,"The Diary of a Young girl",new Author(2,"Anne", "Frank")));
		authorService.saveBookEntry(new Book(103,"The Sun Also Rises",new Author(3,"Ernest", "Hemingway")));
		
		authorService.listAllBooks();

		appContext.close();

	}


}

package jpa_entity_Exercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		AuthorService authorService = (AuthorService) appContext.getBean(AuthorService.class);
		authorService.deleteAllEntry();
/*
		bookService.saveEntry(new Book(1,"The Sun Also Rises","Fiction","Ernest Hemingway"));
		bookService.saveEntry(new Book(2,"To Kill A Mockingbird","Fiction","Harper Lee"));
		bookService.saveEntry(new Book(3,"The Diary of a Young girl","Biograpgy","Anne Frank"));
*/
		authorService.saveEntry(new Author(1,"Ernest", "Hemingway"));
		authorService.saveEntry(new Author(2,"Harper", "Lee"));
		authorService.saveEntry(new Author(3,"Anne", "Frank"));
		
		authorService.listAllAuthors();

		authorService.findById(2);

		authorService.findByLastName("Frank");

		appContext.close();

	}


}

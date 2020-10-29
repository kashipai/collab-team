package jpa_oneToMany;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		AuthorService authorService = (AuthorService) appContext.getBean(AuthorService.class);
		authorService.test();
	
		appContext.close();

	}
}

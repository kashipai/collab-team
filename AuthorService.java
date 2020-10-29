package jpa_oneToMany;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("authorService")
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;
	
	void test() 
	{
		Author author = new Author(1, "Chetan", "Bhagat");
		Author author1 = new Author(2, "Anne", "Frank");

		Book book1 = new Book(101, "2-States",author);
		Book book2 = new Book(102, "Revolution 2020",author);
		Book book3 = new Book(103, "The Diary of a young girl",author1);

		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);

		Set<Book> bookSet1 = new HashSet<Book>();
		bookSet1.add(book1);
		bookSet1.add(book2);

		author.setBooks(bookSet1);

		Set<Book> bookSet2 = new HashSet<Book>();
		bookSet2.add(book3);
		author1.setBooks(bookSet2);

		authorRepository.save(author);
		authorRepository.save(author1);
		System.out.println("Succesfully saved!!");
		
    }
	
}

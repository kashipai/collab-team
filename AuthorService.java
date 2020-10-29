package jpa_oneToOne;
 
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
    
    public void deleteAllEntry()
    {
    	authorRepository.deleteAll();
    	bookRepository.deleteAll();
    	System.out.println("Succesfully deleted!!");
    }
    
    public void saveBookEntry(Book book)
    {
    	bookRepository.save(book);
    	 System.out.println("Succesfully saved!!");
    }
    
    public void listAllBooks()
    {
    	System.out.println("Books List: ");
    	Iterable<Book> iterator = bookRepository.findAll();
        for (Book b : iterator) {
        	System.out.println(b);
		}
    }
}


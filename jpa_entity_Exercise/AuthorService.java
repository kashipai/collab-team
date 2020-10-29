package jpa_entity_Exercise;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("authorService")
public class AuthorService {
    @Autowired
    private AuthorRepository repository;
    
    public void deleteAllEntry()
    {
    	repository.deleteAll();
    	System.out.println("Succesfully deleted!!");
    }
    
    public void saveEntry(Author author)
    {
    	 repository.save(author);
    	 System.out.println("Succesfully saved!!");
    }
    
    public void findById(int id)
    {
    	Optional<Author> result = repository.findById(id);
        result.ifPresent(book -> System.out.println("Author with ID "+id+":"+book));
    }
    
    public void findByLastName(String authorName)
    {
    	System.out.println("Finding Author by last name "+authorName+":");
    	 List<Author> authors = repository.findByLastName(authorName);
 		 for (Author a : authors) {
 			System.out.println(a);
 		}
    }
    
    public void listAllAuthors()
    {
    	System.out.println("Authors List: ");
    	Iterable<Author> iterator = repository.findAll();
        for (Author a : iterator) {
        	System.out.println(a);
		}
    }
}


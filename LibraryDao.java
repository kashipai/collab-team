package springMvcLibrary.Dao;

import springMvcLibrary.Model.Library;
import java.util.List;

public interface LibraryDao {
	
    public int save(Library book);
    
    public int Update(Library book);
    
    public int delete(Integer id);
     
    public Library get(String name);
     
    public List<Library> list();

}

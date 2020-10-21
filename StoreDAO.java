package exercise1610;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository("dao")
public class StoreDAO {

@Autowired
JdbcTemplate jdbcTemplate;
 

public int addItem(Store store){  
    String query="INSERT INTO Database2.Store VALUES('"+store.getProductId()+"','"+store.getProductName()+"','"+store.getPrice()+"','"+store.getQuantity()+"')";  
    return jdbcTemplate.update(query);     
}  

public int updateItem(Store store){  
    String query="UPDATE Database2.Store SET price='"+store.getPrice()+"',quantity='"+store.getQuantity()+"' WHERE productId='"+store.getProductId()+"' ";
    return jdbcTemplate.update(query);  
} 

public int deleteItem(int productId){  
    String query="DELETE FROM Database2.Store WHERE productId='"+productId+"' ";  
    return jdbcTemplate.update(query);  
}

public Store getItem(int  productId) {
	String query="SELECT * FROM Database2.Store WHERE productId ='"+productId+"' ";
	RowMapper<Store> rowMapper=new RowMapperImpl();
	Store item = this.jdbcTemplate.queryForObject(query, rowMapper);
	return item;
}

public List<Store> getAllItems(){
	String query="SELECT * FROM Database2.Store";
	RowMapper<Store> rowMapper1=new RowMapperImpl();
	List<Store> items = this.jdbcTemplate.query(query,rowMapper1);
	return items;
}

public List<Store> getAllStoreItems() {
	String query="SELECT * FROM Database2.Store";
	ResultSetExtractor<List<Store>> resultExtract = new ResultSetExtractorImpl();
	List<Store> items = this.jdbcTemplate.query(query,resultExtract);
	return items;  
}

public  void getAllProducts() {
String query="SELECT * FROM Database2.Store";
RowCallbackHandler rowProcess = new RowCallbackHandlerImpl(); 
jdbcTemplate.query(query, rowProcess);
}
}
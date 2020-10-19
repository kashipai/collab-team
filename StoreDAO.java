package exercise1610;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("dao")
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
public int deleteItem(int id){  
    String query="DELETE FROM Database2.Store WHERE productId='"+id+"' ";  
    return jdbcTemplate.update(query);  
}  
}
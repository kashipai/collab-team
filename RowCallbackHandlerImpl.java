package exercise1610;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

public class RowCallbackHandlerImpl implements RowCallbackHandler{
	public void processRow(ResultSet rs) throws SQLException {
		       do {
		        	int Id = rs.getInt(1);
		        	String productName=rs.getString(2);
		    		int price=rs.getInt(3);
		    		int quantity=rs.getInt(4);
		    		
		    		System.out.println("Store [productId=" +Id + ", productName=" + productName + ", price=" + price + ", quantity="+ quantity + "]");
		        } while (rs.next());
		    }
		
	}



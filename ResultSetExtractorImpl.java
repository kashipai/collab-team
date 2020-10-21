package exercise1610;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ResultSetExtractorImpl implements ResultSetExtractor<List<Store>> {

	public List<Store> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<Store> productList = new ArrayList<Store>();
            while(rs.next()) {
            	Store item = new Store();
        		item.setProductId(rs.getInt(1));
        		item.setProductName(rs.getString(2));
        		item.setPrice(rs.getInt(3));
        		item.setQuantity(rs.getInt(4));
                productList.add(item);
            }
            return productList;
	}

}

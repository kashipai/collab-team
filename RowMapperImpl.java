package exercise1610;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper<Store>{

	public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
		Store item = new Store();
		item.setProductId(rs.getInt(1));
		item.setProductName(rs.getString(2));
		item.setPrice(rs.getInt(3));
		item.setQuantity(rs.getInt(4));
		return item;
	}

}

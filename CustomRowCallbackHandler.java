package com.sowjanya.JdbccSpring.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

public class CustomRowCallbackHandler implements RowCallbackHandler {
	private StringBuilder sb = new StringBuilder();
	  
	  public void processRow(ResultSet rs) throws SQLException {
	    if (sb.length() != 0) {
	      sb.append(", ");
	    }
	    
	    sb.append(rs.getString("name"));
	  }
	  
	  public String getEmployeeNames() {
	    return sb.toString();
	  }

}

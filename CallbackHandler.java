package rowMapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

public class CallbackHandler implements RowCallbackHandler {
	private StringBuilder sb = new StringBuilder();
	  
	  public void processRow(ResultSet rs) throws SQLException {
	    if (sb.length() != 0) {
	      sb.append("\n");
	    }
	    
	    sb.append(rs.getString("bName"));
	  }
	  
	  public String getBookNames() {
	    return sb.toString();
	  }
	}

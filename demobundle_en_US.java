package databasefetchingjsp.i18n;

import java.util.ListResourceBundle;

public class demobundle_en_US extends ListResourceBundle {

		final String[][]contents={{"Employee Record","EMPLOYEE RECORD"},
		                          {"name","NAME"},
		                          {"location","LOCATION"},
		                          {"ID","id"},
		                          {"salary","SALARY"},
		                          {"Submit Query","SUBMITQUERY"}
		                          };
		

		
		protected Object[][] getContents() {
		return contents;
	}

}

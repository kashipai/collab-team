package databasefetchingjsp.i18n;

import java.util.ListResourceBundle;

public class demobundle_de_DE extends ListResourceBundle {
	final String[][]contents={{"Employee Record","Mitarbeiterdatensatz"},
                              {"name","Name"},
                              {"location","Ort"},
                              {"ID","Identifizierung"},
                              {"salary","Linie"},
                              {"Submit Query","Subhmit-Abfrage"}
                              };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}

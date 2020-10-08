package databasefetchingjsp.i18n;

import java.util.ListResourceBundle;

public class demobundle_fr_FR extends ListResourceBundle {
	final String[][]contents={{"Employee Record","Dossier d'employé"},
                              {"name","Nom"},
                              {"location","emplacement"},
                              {"ID","emplacement"},
                              {"salary","un salaire"},
                              {"Submit Query","Soumettre la requête"}
                               };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}

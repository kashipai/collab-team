package rowMapping;

import java.util.List;

public class LibraryDaoImpl implements LibraryDao {

	public void bookInBudget(List<Library> lib, int cost) {
		System.out.println("---BOOKS AVAILABLE WITHIN Rs:"+cost+"---");
		
		for (Library record : lib)
		{   
	         System.out.print("| Name : " + record.getbName() );
	         System.out.print("| Author : " + record.getbAuthor());
	         System.out.println("| Cost : " + record.getCost() );
	     }
	}

	public void alphabeticalArrange(List<Library> list)
	{
		System.out.println("---BOOKS AVAILABLE IN ALPHABETICAL ORDER:---");
		
		for (Library record : list)
		{   
	         System.out.print("| Name : " + record.getbName() );
	         System.out.print("| Author : " + record.getbAuthor());
	         System.out.println("| Cost : " + record.getCost() );
	     }
	}
	
	public void getBooksName(CallbackHandler cbh)
	{
		System.out.println("----BOOKS AVAILABLE IN LIBRARY----");
		System.out.print(cbh.getBookNames());
	}
	

}

package rowMapping;

import java.util.List;

public interface LibraryDao 
{
	void bookInBudget(List<Library> lib,int cost);
	void alphabeticalArrange(List<Library> lib);
	void getBooksName(CallbackHandler cbh);
}

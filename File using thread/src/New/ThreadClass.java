package New;

public class ThreadClass extends Thread {
	private String userData;
	FileHandlerClass fileHandler = new FileHandlerClass();
	ThreadClass(String s){
		userData = s ;
	}
	@Override
	public void run() {
		fileHandler.printToFile(userData);
		
	}

}


public class ChildThread extends Thread  {
	@Override
	public void run() {
		Counter counter= new Counter();
		counter.incrementer();
		}
	

}

package springdependency;

public class ClientA implements Client {
	private Service service;
	
	
	
	

	public ClientA(Service service) {
		super();
		this.service = service;
	}





	public void doSomething() {
		// TODO Auto-generated method stub
		String info=service.getInfo();
		System.out.println(info);
		
	}

	
	
	

}

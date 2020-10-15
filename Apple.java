package sneha.springAnnotation;

public class Apple implements Phone {
	
	Os os;
	String version;
	public Apple(Os os, String version) {
		this.os = os;
		this.version = version;
	}

	public void getPhone() {
		System.out.println("Apple [os=" + os.getOs() + ", version=" + version + "]");
	}

}

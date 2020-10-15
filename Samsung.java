package sneha.springAnnotation;

public class Samsung implements Phone {

	Os os;
	String version;
	public Samsung(Os os, String version) {
		this.os = os;
		this.version = version;

	}

	public void getPhone() {
		System.out.println("Samsung [os=" + os.getOs() + ", version=" + version + "]");
	}


}

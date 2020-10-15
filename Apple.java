package sneha.springAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Apple implements Phone {
	@Autowired @Qualifier("ios")
	Os os;
	String version;
	public Apple( String version) {

		this.version = version;
	}

	public void getPhone() {
		System.out.println("Apple [os=" + os.getOs() + ", version=" + version + "]");
	}

}

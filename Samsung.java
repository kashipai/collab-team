package sneha.springAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Samsung implements Phone {
	@Autowired  @Qualifier("android")
	Os os;
	String version;
	public Samsung( String version) {

		this.version = version;

	}

	public void getPhone() {
		System.out.println("Samsung [os=" + os.getOs() + ", version=" + version + "]");
	}


}

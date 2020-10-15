package spring.frame.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class College {
	
	@Value("ROBSOFT")
	private String CollegeName;
	
	@Autowired
	private Principal principal;
	
	
	@Autowired
	private Teacher teacher;
	/*public College(Principal principal) {
		this.principal = principal;
	}*/
	
	// using setter method 
	
	
	/*public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
		System.out.println("set teacher");
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
		System.out.println("set principal");
	}*/

	public void Test() {
		principal.PrincipalInfo();
		teacher.teach();
		System.out.println("my college name "+CollegeName);
		System.out.println("c  ... hello!!");
	}

}

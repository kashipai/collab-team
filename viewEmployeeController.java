package springMVC;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class viewEmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value = "/read")
	public ModelAndView readEmployee(ModelAndView model) throws IOException{
	
		List<Employee> listEmployee = employeeDao.read();
		model.addObject("listEmployee",listEmployee);
		model.setViewName("read");
		
		return model;
	}
}

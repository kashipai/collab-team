package springMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddEmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	
	public ModelAndView addEmployee(@RequestParam("id")int id,@RequestParam("name")String name, ModelAndView mv) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		
		int counter = employeeDao.add(employee);
		

		if (counter > 0) {
			mv.addObject("msg", "Employee registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("add");

		return mv;
	}
}

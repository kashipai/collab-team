package demo_spring_mvc_student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import demo_spring_mvc.student.dao.StudentDao;
import demo_spring_mvc.student.model.Student;

@Controller
public class MainController {
	
    @Autowired
	private StudentDao StudentDao;
	
	@RequestMapping(value = "/")
	public ModelAndView Display(ModelAndView model) {
		List<Student> students =StudentDao.getAllStudent();
		model.addObject("studentList",students);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/new",method=RequestMethod.GET)
	public ModelAndView newStudent(ModelAndView model) {
		Student newstudent=new Student();
		model.addObject("student",newstudent);
		model.setViewName("student_form");
		return model;
	}

	@RequestMapping(value = "/save",method=RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		StudentDao.insert(student);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam Integer rollNo) {
		StudentDao.delete(rollNo);
		return new ModelAndView("redirect:/");
	}
}

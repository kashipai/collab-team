package com.example.springSecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springSecurity.Model.Person;
import com.example.springSecurity.Repository.PersonRepo;

@Controller
public class ApplicationController 
{
	@Autowired
	private PersonRepo repo;

	@RequestMapping("/")
	public String homePage()
	{
		return "<h1>WELCOME<h1>";
	}
	
	@RequestMapping("/list")
	public String viewList(Model model) {
	    List<Person> listPerson = repo.findAll();
	    model.addAttribute("listPerson", listPerson);
	     
	    return "list";
	}
	
	@RequestMapping("/newPerson")
	public String addPerson(Model model) {
		Person person = new Person();
	    model.addAttribute("person", person);
	     
	    return "newPerson";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePerson(@ModelAttribute("person") Person person) {
	    repo.save(person);
	     
	    return "redirect:/";
	}
	
	@GetMapping("/accessDenied")
    public String error403() {
		return "<centre><h1>ACCESS DENIED.!<h1>"+
				"<h3>You currently dont have permission to view this page<h3></centre>";
	}
	
}


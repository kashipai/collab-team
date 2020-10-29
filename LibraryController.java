package springMvcLibrary.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springMvcLibrary.Dao.LibraryDao;
import springMvcLibrary.Model.Library;

	@Controller
	public class LibraryController {
		@Autowired
		private LibraryDao dao;
		
		@RequestMapping(value = "/",method= RequestMethod.GET)
		public ModelAndView listEmployee(ModelAndView model) {
			List<Library> list = dao.list();
			model.addObject("list", list);
			model.setViewName("index");
			return model;
			
		}
		
		@RequestMapping(value = "/newform", method= RequestMethod.GET)
		public ModelAndView newEmployee(ModelAndView model) {
			Library book = new Library();
			model.addObject("book", book);
			model.setViewName("newform");
			return model;
			
		}
		
		@RequestMapping(value = "/save", method= RequestMethod.POST)
		public ModelAndView SaveEmployee(@ModelAttribute Library lib) {
			dao.save(lib);
			return new ModelAndView("redirect:/");
			
		}
		@RequestMapping(value = "/edit", method= RequestMethod.GET)
		public ModelAndView editEmployee(HttpServletRequest req) {
			String name = req.getParameter("name");
			Library book = dao.get(name);
			ModelAndView model = new ModelAndView("newform");
			model.addObject("book", book);
			model.setViewName("edit");
			
			return model;
			
		}
		@RequestMapping(value = "/delete", method= RequestMethod.GET)
		public ModelAndView deleteEmployee(@RequestParam Integer id) {
			dao.delete(id);
			return  new ModelAndView("redirect:/");
			
		}

	}

	

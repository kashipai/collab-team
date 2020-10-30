package springMVC.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springMVC.Dao.CustomerDao;
import springMVC.Model.Customer;

@Controller
public class CustomerController {
    @Autowired
    private CustomerDao dao;

    @RequestMapping(value = "/",method= RequestMethod.GET)
    public ModelAndView listEmployee(ModelAndView model) {
        List<Customer> list = dao.list();
        model.addObject("list", list);
        model.setViewName("index");
        return model;

    }

    @RequestMapping(value = "/newform", method= RequestMethod.GET)
    public ModelAndView newEmployee(ModelAndView model) {
        Customer customer = new Customer();
        model.addObject("customer", customer);
        model.setViewName("newform");
        return model;

    }

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public ModelAndView SaveEmployee(@ModelAttribute Customer customer) {
        dao.save(customer);
        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "/delete", method= RequestMethod.GET)
    public ModelAndView deleteEmployee(@RequestParam Integer id) {
        dao.delete(id);
        return  new ModelAndView("redirect:/");

    }

}

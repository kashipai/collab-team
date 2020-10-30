package springMVC.Dao;

import springMVC.Model.Customer;
import java.util.List;

public interface CustomerDao {

    public int save(Customer customer);

    public int delete(Integer id);

    public List<Customer> list();

}

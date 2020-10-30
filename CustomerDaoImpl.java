package springMVC.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import springMVC.Model.Customer;
import org.springframework.jdbc.core.RowMapper;

public class CustomerDaoImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public int save(Customer customer) {
        String sql = "INSERT INTO customer Values(?,?,?,?)";
        Object[] obj = {customer.getId(),customer.getFirstname(),customer.getLastname(),customer.getEmail()};
        jdbcTemplate.update(sql, obj);
        System.out.println("New Customer Added");
        return 1;
    }

    @Override
    public int delete(Integer id) {
        String sql = "Delete from customer where id ="+id;
        jdbcTemplate.update(sql);
        System.out.println("Customer Deleted Successfully");

        return 1;
    }

    @Override
    public List<Customer> list() {
        String sql = "SELECT * FROM customer";

        RowMapper<Customer> rowmap = new RowMapper <Customer>() {

            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");

                return new Customer(id, firstname, lastname, email);
            }

        };
        return jdbcTemplate.query(sql, rowmap);

    }

}



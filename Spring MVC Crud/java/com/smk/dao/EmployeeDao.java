package com.smk.dao;
import java.util.List;

import com.smk.dto.*;

public interface EmployeeDao {
	public int saveOrUpdate(Employee employee);
    
    public int delete(int employeeid);
     
    public Employee get(int employeeid);
     
    public List<Employee> list();

}

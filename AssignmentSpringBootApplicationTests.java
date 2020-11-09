package com.springBoot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
import java.util.ArrayList;
import java.util.List;
 
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBoot.model.Employee;
import com.springBoot.service.EmployeeService;
 
@WebMvcTest
public class AssignmentSpringBootApplicationTests {
	
    @Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private EmployeeService service;
 
    private static ObjectMapper mapper = new ObjectMapper();
   
    @Test
    public void testGetExample() throws Exception {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(100,"Alice","John",25));
        employees.add(new Employee(101,"Bob","Martin",30));
        employees.add(new Employee(102,"Charles","Darwin",35));
        
        Mockito.when(service.getAllEmployees()).thenReturn(employees);
        mockMvc.perform(get("/employee"))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$", Matchers.hasSize(3)))
        	.andExpect(jsonPath("$[0].firstName", Matchers.equalTo("Alice")));
    }
    
    @Test
    public void testGetByIdExample() throws Exception {
        
        Employee employee=new Employee(111,"Bob","Martin",30);
    	Mockito.when(service.getById(ArgumentMatchers.anyInt())).thenReturn(employee);
        mockMvc.perform(get("/employee/{empId}","111"))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$.empId", Matchers.equalTo(111)))
            .andExpect(jsonPath("$.firstName", Matchers.equalTo("Bob")));
    }
 
    @Test
    public void testPostExample() throws Exception {
    	Employee employee=new Employee(111,"Alexa","Siri",30);
    	Mockito.when(service.saveOrUpdate(ArgumentMatchers.any())).thenReturn(employee);
    	String json = mapper.writeValueAsString(employee);
        mockMvc.perform(post("/employee").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.empId", Matchers.equalTo(111)))
                .andExpect(jsonPath("$.firstName", Matchers.equalTo("Alexa")));
    	
    }
 
    @Test
    public void testPutExample() throws Exception {
    	Employee employee=new Employee(102,"Charles","Darwin",35);
        Mockito.when(service.saveOrUpdate(ArgumentMatchers.any())).thenReturn(employee);
        String json = mapper.writeValueAsString(employee);
        mockMvc.perform(put("/employee").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.empId", Matchers.equalTo(102)))
                .andExpect(jsonPath("$.lastName", Matchers.equalTo("Darwin")));
    }
 
    @Test
    public void testDeleteExample() throws Exception {
    	
        Mockito.when(service.deleteById(ArgumentMatchers.anyInt())).thenReturn(true);
        MvcResult requestResult = mockMvc.perform(delete("/employee/{empId}","103"))
                .andExpect(status().isOk()).andReturn();
        String result = requestResult.getResponse().getContentAsString();
        assertEquals(result, "true");
    }
}
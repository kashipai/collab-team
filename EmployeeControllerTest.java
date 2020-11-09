package com.example.employeerest.controller;

import com.example.employeerest.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext appContext;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void init()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(appContext).build();
    }
    @Test
    void getall()  throws Exception {
        mockMvc.perform(get("/allEmployees")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }


    @Test
    void addEmployee() throws  Exception {
        Employee employee = new Employee(1,"John",23,"React");
        String requestStr = mapper.writeValueAsString(employee);
        MvcResult result = mockMvc.perform(post("/addEmployee")
                .content(requestStr).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();
        Employee response = mapper.readValue(resultContent, Employee.class);

        assertTrue(1 == response.getId());
    }

}
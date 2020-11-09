package com.example.libraryRest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.example.libraryRest.Model.Library;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ExtendWith(SpringExtension.class) 
class ControllerTest {

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
	void listBooksTest()  throws JsonProcessingException, Exception
	{
		MvcResult result = mockMvc.perform(get("/library")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().is2xxSuccessful())
					.andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Library[] response = mapper.readValue(resultContent, Library[].class);

		assertEquals(10, response.length);
	}
	
	@Test
	void addBooktest()  throws JsonProcessingException, Exception 
	{
		Library book = new Library(1357,"Engineering Maths 2","Mc Graw-Hill",400);
		String jsonRequest = mapper.writeValueAsString(book);
		MvcResult result = mockMvc.perform(post("/libAdd")
							.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
							.andExpect(status().isCreated())
							.andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		Library response = mapper.readValue(resultContent, Library.class);
		
		assertTrue(1357 == response.getId());
	}
	
	@Test
	void findByauthorTest()  throws JsonProcessingException, Exception
	{
		MvcResult result = mockMvc.perform(get("/bookby/Mc Graw-Hill")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		Library response = mapper.readValue(resultContent, Library.class);

		assertTrue(1357 == response.getId());
	}
	
	@Test
	void updateTest()  throws JsonProcessingException, Exception
	{
		Library book = new Library(1357,"Engineering Maths-2","Mc Graw-Hill",450);
		String jsonRequest = mapper.writeValueAsString(book);
		
		MvcResult result = mockMvc.perform(put("/update/1357")
							.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
							.andExpect(status().is2xxSuccessful())
							.andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Library response = mapper.readValue(resultContent, Library.class);
		
		assertEquals("Engineering Maths-2", response.getName());

		} 
	
	@Test
	void deleteTest()  throws JsonProcessingException, Exception
	{
		MvcResult result = mockMvc.perform(get("/delete/1357")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk())
					.andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		Library response = mapper.readValue(resultContent, Library.class);

		assertTrue(1357 == response.getId());
	}  
	
	}



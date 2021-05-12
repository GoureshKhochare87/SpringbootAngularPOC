package com.neosoft.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.springboot.dto.ResultModel;
import com.neosoft.springboot.model.Employee;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class SpringbootBackendApplicationTests {
private MockMvc mockMvc;
@Autowired
private WebApplicationContext context;

ObjectMapper objectMapper = new ObjectMapper();

@BeforeAll
public void setUp()
{
	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
}

@Test
public void createEmployee() throws Exception{
	Employee employee=new Employee();
	employee.setFirstName("Gouresh");
	employee.setLastName("Khochare");
	employee.setEmailId("gouresh@gmail.com");
	employee.setMobileNo(9090909090L);
	employee.setCity("Thane");
	employee.setCountry("India");
	String JsonRequest= objectMapper.writeValueAsString(employee);
	MvcResult result=mockMvc.perform(post("/api/v1/employeestest").content(JsonRequest).contentType(
	MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isOk()).
	andReturn();
	String resultContext =result.getResponse().getContentAsString(); 
	ResultModel response=objectMapper.readValue(resultContext, ResultModel.class);
	Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
	Assertions.assertEquals("Success",response.getProgressMessage());
}

@Test
public void getAllEmployees() throws Exception{
	MvcResult result = mockMvc.perform(get("/api/v1/employeestest").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
			.andExpect(status().isOk()).andReturn();
	String resultContext = result.getResponse().getContentAsString();
	ResultModel response = objectMapper.readValue(resultContext, ResultModel.class);
	Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
	Assertions.assertEquals("Success",response.getProgressMessage());
}

@Test
public void getEmployeeById() throws Exception{
	MvcResult result = mockMvc.perform(get("/api/v1/employeestest/1").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
			.andExpect(status().isOk()).andReturn();
	String resultContext = result.getResponse().getContentAsString();
	ResultModel response = objectMapper.readValue(resultContext, ResultModel.class);
	Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
	Assertions.assertEquals("Success",response.getProgressMessage());
}

@Test
public void updateEmployeeTest() throws Exception{
	Employee employee=new Employee();
	employee.setFirstName("Rohan");
	employee.setLastName("Patil");
	employee.setEmailId("rohan@gmail.com");
	employee.setMobileNo(8080808080L);
	employee.setCity("Pune");
	employee.setCountry("India");
	String JsonRequest= objectMapper.writeValueAsString(employee);
	MvcResult result=mockMvc.perform(put("/api/v1/employeestest/2").content(JsonRequest).contentType(
	MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isOk()).
	andReturn();
	String resultContext =result.getResponse().getContentAsString(); 
	ResultModel response=objectMapper.readValue(resultContext, ResultModel.class);
	Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
	Assertions.assertEquals("Success",response.getProgressMessage());
}

@Test
public void deleteEmployeeTest() throws Exception{
	MvcResult result =  mockMvc.perform(delete("/api/v1/employeestest/6").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).
    andExpect(status().isOk()).andReturn(); 
	String resultContext=result.getResponse().getContentAsString(); 
	ResultModel response=objectMapper.readValue(resultContext, ResultModel.class);
    Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
    Assertions.assertEquals("Success",response.getProgressMessage()); 
}

@Test
public void getEmployeeByName() throws Exception{
	MvcResult result = mockMvc.perform(get("/api/v1/employeesnametest/Gouresh").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
			.andExpect(status().isOk()).andReturn();
	String resultContext = result.getResponse().getContentAsString();
	ResultModel response = objectMapper.readValue(resultContext, ResultModel.class);
	Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
	Assertions.assertEquals("Success",response.getProgressMessage());
}
}
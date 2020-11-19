package com.project.employees;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;


import com.jayway.jsonpath.JsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;




@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:application-tst.properties")
public class EmployeesControllerTests extends TestAux{


	@Autowired
	public MockMvc mockMvc;
	


	@Test
	void execTests() throws Exception{
		setUp();
		authGetAuthorization();
		employeeCreate();
		employeeUpdate();
		employeeDetail();
		employeeList();
		employeeDelete();
	}

	private void authGetAuthorization() throws Exception {
		ResultActions results = this.mockMvc.perform(get("/auth/key-access").header("Content-Type", "application/json"));
		MvcResult returnMock = results.andExpect(status().isOk()).andReturn();
		setValue(AUTHORIZATION,returnMock.getResponse().getContentAsString());
		
	}

	private void employeeCreate() throws Exception {
		

		setValue(NAME,generateName());
		setValue(EMAIL,generateEmail());
		setValue(DEPARTMENT,generateName());
		setValue(SALARY, generatedFloat(1500, 3500));
		setValue(BIRTHDATE,generateLocaldateAsString(504921600000l, 536457600000l, "dd-MM-yyyy"));


		ResultActions results = this.mockMvc.perform(
				post("/employees")
				.content( buildBodyJson(NAME,EMAIL,DEPARTMENT,SALARY ,BIRTHDATE))
				.header(AUTHORIZATION, getValueAsString(AUTHORIZATION))
				.header("Content-Type", "application/json")
				);


		MvcResult returnMock = results
				.andExpect(status().isCreated() )
				.andExpect( jsonPath("$." + ID).isNumber())
				.andExpect( jsonPath("$." + NAME).value(getValueAsString(NAME)) )
				.andExpect( jsonPath("$." + EMAIL).value(getValueAsString(EMAIL)) )
				.andExpect( jsonPath("$." + DEPARTMENT).value(getValueAsString(DEPARTMENT)) )
				.andExpect( jsonPath("$." + SALARY).value(getValueAsString(SALARY)) )
				.andExpect( jsonPath("$." + BIRTHDATE).value(getValueAsString(BIRTHDATE)) )
				.andReturn();
	
		setValue(ID , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + ID,Long.class));
		
	}


	private void employeeUpdate() throws Exception {

		setValue(NAME,generateName());
		setValue(EMAIL,generateEmail());
		setValue(DEPARTMENT,generateName());
		setValue(SALARY, generatedFloat(1500, 3500));
		setValue(BIRTHDATE,generateLocaldateAsString(504921600000l, 536457600000l, "dd-MM-yyyy"));

		ResultActions results = this.mockMvc.perform(
				put("/employees/" + getValueAsString(ID) )
				.content( buildBodyJson(NAME,EMAIL,DEPARTMENT,SALARY ,BIRTHDATE))
				.header(AUTHORIZATION, getValueAsString(AUTHORIZATION))
				.header("Content-Type", "application/json")
				);


		results.andExpect(status().isOk() )
				.andExpect( jsonPath("$." + ID).isNumber())
				.andExpect( jsonPath("$." + NAME).value(getValueAsString(NAME)) )
				.andExpect( jsonPath("$." + EMAIL).value(getValueAsString(EMAIL)) )
				.andExpect( jsonPath("$." + DEPARTMENT).value(getValueAsString(DEPARTMENT)) )
				.andExpect( jsonPath("$." + SALARY).value(getValueAsString(SALARY)) )
				.andExpect( jsonPath("$." + BIRTHDATE).value(getValueAsString(BIRTHDATE)) );
	}

	
	private void employeeDetail() throws Exception {

		ResultActions results = this.mockMvc.perform(
				get("/employees/" + getValueAsString(ID) )
				.header(AUTHORIZATION, getValueAsString(AUTHORIZATION))
				.header("Content-Type", "application/json")
				);

			results.andExpect(status().isOk() )
				.andExpect( jsonPath("$." + ID).isNumber())
				.andExpect( jsonPath("$." + NAME).value(getValueAsString(NAME)) )
				.andExpect( jsonPath("$." + EMAIL).value(getValueAsString(EMAIL)) )
				.andExpect( jsonPath("$." + DEPARTMENT).value(getValueAsString(DEPARTMENT)) )
				.andExpect( jsonPath("$." + SALARY).value(getValueAsString(SALARY)) )
				.andExpect( jsonPath("$." + BIRTHDATE).value(getValueAsString(BIRTHDATE)) )
				.andReturn();


	}

	private void employeeList() throws Exception {

		ResultActions results = this.mockMvc.perform(
				get("/employees" )
				.header(AUTHORIZATION, getValueAsString(AUTHORIZATION))
				.header("Content-Type", "application/json")
				);


	
		results.andExpect(status().isOk() )
				.andExpect( jsonPath("$.*" , hasSize(1) ) )
				.andExpect( jsonPath("$.[0]." + ID ,is( getValue(ID, Long.class)) , Long.class ))
				.andExpect( jsonPath("$.[0]." + NAME).value(getValueAsString(NAME)) )
				.andExpect( jsonPath("$.[0]." + EMAIL).value(getValueAsString(EMAIL)) )
				.andExpect( jsonPath("$.[0]." + DEPARTMENT).value(getValueAsString(DEPARTMENT)) )
				.andExpect( jsonPath("$.[0]." + SALARY).value(getValueAsString(SALARY)) )
				.andExpect( jsonPath("$.[0]." + BIRTHDATE).value(getValueAsString(BIRTHDATE)) );


	}


	private void employeeDelete() throws Exception {

	
		ResultActions results = this.mockMvc.perform(
				delete("/employees/" + getValueAsString(ID) )
				.content( buildBodyJson(NAME,EMAIL,DEPARTMENT,SALARY ,BIRTHDATE))
				.header(AUTHORIZATION, getValueAsString(AUTHORIZATION))
				.header("Content-Type", "application/json")
				);


		results.andExpect(status().isOk() )
				.andExpect( jsonPath("$." + ID).isNumber())
				.andExpect( jsonPath("$." + NAME).value(getValueAsString(NAME)) )
				.andExpect( jsonPath("$." + EMAIL).value(getValueAsString(EMAIL)) )
				.andExpect( jsonPath("$." + DEPARTMENT).value(getValueAsString(DEPARTMENT)) )
				.andExpect( jsonPath("$." + SALARY).value(getValueAsString(SALARY)) )
				.andExpect( jsonPath("$." + BIRTHDATE).value(getValueAsString(BIRTHDATE)) );

		
		
			this.mockMvc.perform(
					get("/employees" )
					.header(AUTHORIZATION, getValueAsString(AUTHORIZATION))
					.header("Content-Type", "application/json")
					).andExpect(status().isOk() )
					.andExpect( jsonPath("$.*" , hasSize(0) ) );
			

		
	}





	
	
}

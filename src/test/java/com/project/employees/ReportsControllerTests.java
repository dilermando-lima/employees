package com.project.employees;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class ReportsControllerTests extends TestAux{


	@Autowired
	public MockMvc mockMvc;

	
	@Test
	void execTests() throws Exception{
		setUp();
		authGetAuthorization();
		employeeCreateHighest();
		employeeCreateLowest();
		employeeCreateOlder();
		employeeCreateYounger();
		reportsEmployeesAge();
		reportsEmployeesSalary();

	}

	private void authGetAuthorization() throws Exception {
		ResultActions results = this.mockMvc.perform(get("/auth/key-access").header("Content-Type", "application/json"));
		MvcResult returnMock = results.andExpect(status().isOk()).andReturn();
		setValue(AUTHORIZATION,returnMock.getResponse().getContentAsString());
		
	}

	private void employeeCreateOlder() throws Exception {

		setValue(NAME,generateName());
		setValue(EMAIL,generateEmail());
		setValue(DEPARTMENT,generateName());
		setValue(SALARY, generatedFloat(2500, 3000));
		setValue(BIRTHDATE,generateLocaldateAsString(315532800000l, 473385600000l, "dd-MM-yyyy"));


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
	
		setValue(ID_OLDER , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + ID,Long.class));
		setValue(BIRTHDATE_OLDER , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + BIRTHDATE,String.class));
		setValue(SALARY_OLDER , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + SALARY,String.class));



	}


	private void employeeCreateYounger() throws Exception {

		setValue(NAME,generateName());
		setValue(EMAIL,generateEmail());
		setValue(DEPARTMENT,generateName());
		setValue(SALARY, generatedFloat(2500, 3000));
		setValue(BIRTHDATE,generateLocaldateAsString(599616000000l, 788918400000l, "dd-MM-yyyy"));


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
	
		setValue(ID_YOUNGER , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + ID,Long.class));
		setValue(BIRTHDATE_YOUNGER , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + BIRTHDATE,String.class));
		setValue(SALARY_YOUNGER , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + SALARY,String.class));


	
	}


	private void employeeCreateLowest() throws Exception {

		setValue(NAME,generateName());
		setValue(EMAIL,generateEmail());
		setValue(DEPARTMENT,generateName());
		setValue(SALARY, generatedFloat(1500, 2000));
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
	
		setValue(ID_LOWEST , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + ID,Long.class));
		setValue(SALARY_LOWEST , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + SALARY,String.class));



	
	}


	private void employeeCreateHighest() throws Exception {

		setValue(NAME,generateName());
		setValue(EMAIL,generateEmail());
		setValue(DEPARTMENT,generateName());
		setValue(SALARY, generatedFloat(5000, 7000));
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
	
		setValue(ID_HIGHEST , JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + ID,Long.class));
		setValue(SALARY_HIGHEST, JsonPath.parse(returnMock.getResponse().getContentAsString()).read("$." + SALARY,String.class));



	
	}


	

	private void reportsEmployeesAge()  throws Exception{

		ResultActions results = this.mockMvc.perform(
			get("/reports/employees/age")
			.header(AUTHORIZATION, getValueAsString(AUTHORIZATION))
			.header("Content-Type", "application/json")
			);

		results
			.andExpect(status().isOk() )
			.andExpect( jsonPath("$.younger.id"  ,is( getValue(ID_YOUNGER, Long.class)) , Long.class ))
			.andExpect( jsonPath("$.younger.birth_date"  ,is( getValue(BIRTHDATE_YOUNGER, String.class)) , String.class ))
			.andExpect( jsonPath("$.younger.salary"  ,is( getValue(SALARY_YOUNGER, String.class)) , String.class ))
			.andExpect( jsonPath("$.older.id"  ,is( getValue(ID_OLDER, Long.class)) , Long.class ))
			.andExpect( jsonPath("$.older.birth_date"  ,is( getValue(BIRTHDATE_OLDER, String.class)) , String.class ))
			.andExpect( jsonPath("$.older.salary"  ,is( getValue(SALARY_OLDER, String.class)) , String.class ));
		


	}


	private void reportsEmployeesSalary()  throws Exception{

		ResultActions results = this.mockMvc.perform(
			get("/reports/employees/salary")
			.header(AUTHORIZATION, getValueAsString(AUTHORIZATION))
			.header("Content-Type", "application/json")
			);

		results
			.andExpect(status().isOk() )
			.andExpect( jsonPath("$.lowest.id"  ,is( getValue(ID_LOWEST, Long.class)) , Long.class ))
			.andExpect( jsonPath("$.lowest.salary"  ,is( getValue(SALARY_LOWEST, String.class)) , String.class ))
			.andExpect( jsonPath("$.highest.id"  ,is( getValue(ID_HIGHEST, Long.class)) , Long.class ))
			.andExpect( jsonPath("$.highest.salary"  ,is( getValue(SALARY_HIGHEST, String.class)) , String.class ));


	}





	
	
}

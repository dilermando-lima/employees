package com.project.employees;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


// @ExtendWith(SpringExtension.class)
// @AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:application-tst.properties")
class EmployeesApplicationTests {

	@Test
	void contextLoads() {
	}

}

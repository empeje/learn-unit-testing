package io.mpj.in28minutes.unittesting.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
class UnitTestingApplicationTests {

	@Test
	void contextLoads() {
	}

}

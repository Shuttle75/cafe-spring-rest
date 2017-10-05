package org.shuttle75.samples.cafe.service;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
public class ApplicationTestConfig {
	
	public ApplicationTestConfig(){
		MockitoAnnotations.initMocks(this);
	}

}

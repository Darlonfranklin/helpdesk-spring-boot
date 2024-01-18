package com.darlon.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.darlon.helpdesk.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

  
    void instanceDB() {
		this.dbService.instanceDB();
    }
}

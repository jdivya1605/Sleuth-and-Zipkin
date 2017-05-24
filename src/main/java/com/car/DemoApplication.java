package com.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {
	
	
	private static Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
    public static void main(String[] args) {
    	
    	
    	 log.info("Handling Main");
        SpringApplication.run(DemoApplication.class, args);
    }


   


}

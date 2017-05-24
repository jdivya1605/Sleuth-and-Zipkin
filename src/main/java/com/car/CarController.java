package com.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Level;

@RestController
public class CarController {

    @Autowired
    private CarService carService;
    
    @Autowired
   	private RestTemplate restTemplate;
   	
       @Bean
       public RestTemplate getRestTemplate() {
           return new RestTemplate();
       }   
      
	
    
    private static Logger log = LoggerFactory.getLogger(DemoApplication.class);
    @RequestMapping("/home")
    public String home() {
    	 log.info("Handling ***************************************  Microservice 2     ****************************");
        return "Microservice 2!!";
    }

    @RequestMapping("/Cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/Car")
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @RequestMapping("/find")
    public List<Car> findSpecific(@RequestParam String make, @RequestParam String year) {
        return carService.find(make, year);
    }
    @RequestMapping("/id5")
    public List<Car> nativeQuery() {
        return carService.nativeQuery();
    }
    @RequestMapping("/findOwnerCar")
    public List<Car> findOwnerCar(@RequestParam int id) {
        return carService.findOwner(id);
    }
    
    @RequestMapping("/callhome")
    public String callHome() {
    	log.info("landed on Microservice 2");
    	log.info("from Microservice 2");
        return restTemplate.getForObject("http://localhost:8080/finaldestination/", String.class);
    }
    
}

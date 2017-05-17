package com.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/")
    public String home(){
        return "ok!!";
    }

    @RequestMapping("/getallCars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @PostMapping("/Car")
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }
}

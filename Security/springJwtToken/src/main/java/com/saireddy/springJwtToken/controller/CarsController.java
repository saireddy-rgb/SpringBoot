package com.saireddy.springJwtToken.controller;

import com.saireddy.springJwtToken.model.Cars;
import com.saireddy.springJwtToken.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CarsController {

    @Autowired
    private CarsService service;


    @GetMapping("/cars")
    public List<Cars> getAllCars(){
       return service.getAllCars();
    }

    @GetMapping("/cars/{carId}")
    private Cars getCarById(@PathVariable long carId){
        return service.getCarById(carId);
    }

    @PostMapping("/cars")
    public Cars addCars(@RequestBody Cars cars){
        return service.addCars(cars);
    }

    @PutMapping("/cars")
public  Cars updateCarDetails(@RequestBody Cars cars){
        return service.updateCarDetails(cars);
    }

    @DeleteMapping("/cars/{carId}")
    public String deleteCarDetails(@PathVariable long carId) {
        service.deleteCarDetails(carId);
        return "car deleted sucessfully";
    }
}

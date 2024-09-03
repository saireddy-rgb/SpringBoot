package com.saireddy.springJwtToken.service;

import com.saireddy.springJwtToken.model.Cars;
import com.saireddy.springJwtToken.repo.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    public CarsRepo repo;

    public List<Cars> getAllCars() {
        return repo.findAll();
    }

    public Cars getCarById(long carId) {
        Optional<Cars> cars = repo.findById(carId);
        if (cars.isPresent()) {
            return cars.get();
        } else {
            throw new RuntimeException();
        }
    }

    public Cars addCars(Cars cars) {
        return repo.save(cars);
    }

    public Cars updateCarDetails(Cars cars) {
        Cars existingCar = repo.findById(cars.getCarId()).orElseThrow(() -> new RuntimeException());
        existingCar.setCarModel(cars.getCarModel());
        existingCar.setCarName(cars.getCarName());
        existingCar.setPrice(cars.getPrice());
        repo.save(existingCar);
        return existingCar;
    }

    public void deleteCarDetails(long carId) {
        repo.findById(carId).orElseThrow(() -> new RuntimeException());
        repo.deleteById(carId);
    }
}

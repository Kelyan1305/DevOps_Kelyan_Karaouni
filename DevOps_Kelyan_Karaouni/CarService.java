package com.example.DevOps_Kelyan_Karaouni;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarService {
    private final Map<String, Car> cars = new HashMap<>();

    public CarService() {
        // Initialisation avec quelques voitures
        cars.put("11AA22", new Car("11AA22", "Ferrari", 100));
        cars.put("33BB44", new Car("33BB44", "Lamborghini", 200));
        cars.put("AA11BB", new Car("AA11BB", "Porsche", 150));
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars.values());
    }

    public Car getCar(String plateNumber) {
        return cars.get(plateNumber);
    }

    public Car rentCar(String plateNumber, Dates dates) {
        Car car = cars.get(plateNumber);
        if (car != null && !car.isRented()) {
            car.setRented(true);
            car.setBeginRent(dates.getBegin());
            car.setEndRent(dates.getEnd());
            return car;
        }
        return null;
    }

    public Car returnCar(String plateNumber) {
        Car car = cars.get(plateNumber);
        if (car != null && car.isRented()) {
            car.setRented(false);
            car.setBeginRent(null);
            car.setEndRent(null);
            return car;
        }
        return null;
    }
}


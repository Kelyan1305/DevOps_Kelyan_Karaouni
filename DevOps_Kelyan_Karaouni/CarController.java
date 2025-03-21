package com.example.DevOps_Kelyan_Karaouni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    // Obtenir la liste de toutes les voitures
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return carService.getAllCars();
    }

    // Obtenir les caractéristiques d'une voiture
    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        Car car = carService.getCar(plateNumber);
        if (car == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Voiture non trouvée avec plaque d'immatriculation: " + plateNumber
            );
        }
        return car;
    }

    // Louer ou récupérer une voiture
    @PutMapping(value = "/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent", required = true) boolean rent,
            @RequestBody(required = false) Dates dates) throws Exception {

        Car car = carService.getCar(plateNumber);
        if (car == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Voiture non trouvée avec plaque d'immatriculation: " + plateNumber
            );
        }

        if (rent) {
            // Louer une voiture
            if (dates == null || dates.getBegin() == null || dates.getEnd() == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Les dates de début et de fin sont requises pour la location"
                );
            }

            Car rentedCar = carService.rentCar(plateNumber, dates);
            if (rentedCar == null) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "La voiture est déjà louée"
                );
            }
        } else {
            // Retourner une voiture
            Car returnedCar = carService.returnCar(plateNumber);
            if (returnedCar == null) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "La voiture n'est pas actuellement louée"
                );
            }
        }
    }
}

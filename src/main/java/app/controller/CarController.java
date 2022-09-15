package app.controller;

import app.model.Car;
import app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String welcome() {return "Hello World!";}

    @GetMapping("/cars")
    public List<Car> list() {
        return carService.list();
    }

    @PutMapping("/cars/{id}")
    public void rent(
            @PathVariable Integer id,
            @RequestParam String action
    ) {
        carService.rent(id, action.toUpperCase());
    }

}

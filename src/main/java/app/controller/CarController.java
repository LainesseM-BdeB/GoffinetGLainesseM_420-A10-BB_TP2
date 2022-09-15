package app.controller;

import app.model.Car;
import app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

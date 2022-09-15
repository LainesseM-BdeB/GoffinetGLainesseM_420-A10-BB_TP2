package app.controller;

import app.model.Car;
import app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public RedirectView start() {
        return new RedirectView("/homepage");
    }

    @GetMapping("/homepage")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        List<Car> cars = list();
        model.addObject("cars", cars);
        return model;
    }

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

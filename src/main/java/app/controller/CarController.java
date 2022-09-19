package app.controller;

import app.model.Car;
import app.service.CarService;
import app.utils.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String showCarList(Model model) {
        List<Car> carsList = carService.listAll();
        model.addAttribute("carsList", carsList);
        return "cars";
    }

    @GetMapping("/cars/new")
    public String showNewForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("pageTitle", "Add new car");
        return "car_form";
    }

    @PostMapping("/cars/save")
    public String saveCar(Car car, RedirectAttributes ra) {
        carService.save(car);
        ra.addFlashAttribute("successMessage", "The car has been saved successfully");
        return "redirect:/cars";
    }

    @GetMapping("/cars/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Car car = carService.getById(id);
            model.addAttribute("car", car);
            model.addAttribute("pageTitle", "Edit car (ID " + id + " )");
            return "car_form";
        } catch (CarNotFoundException e) {
            ra.addFlashAttribute("warningMessage", e.getMessage());
            return "redirect:/cars";
        }
    }

    @GetMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            carService.delete(id);
            ra.addFlashAttribute("successMessage", "The car has been deleted successfully");
        } catch (CarNotFoundException e) {
            ra.addFlashAttribute("warningMessage", e.getMessage());
        }
        return "redirect:/cars";
    }
}

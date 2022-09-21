package app.controller;

import app.model.Car;
import app.service.CarService;
import app.utils.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * TP2
 * Cours 420-A10-BB
 * @author Maxime Lainesse, Gaëlle Goffinet
 * @since 2022-09
 */

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * Afficher la liste de toutes les voitures
     * @param model pour transmettre la liste des voitures à la page html
     * @return la liste de toutes les voitures à la page html qui va les afficher
     */
    @GetMapping("/cars")
    public String showCarsList(Model model) {
        List<Car> carsList = carService.listAll();
        model.addAttribute("carsList", carsList);
        return "cars";
    }

    /**
     * Afficher la liste des voitures louées
     * @param model pour transmettre la liste des voitures à la page html
     * @param ra pour afficher un message si aucune voiture n'est louée
     * @return la liste des voitures louées si elle n'est pas vide
     */
    @GetMapping("/rentedcars")
    public String showRentedCarsList(Model model, RedirectAttributes ra) {
        List<Car> carsList = carService.listAll();
        List<Car> rentedCarsList = new ArrayList<>();
        for (Car car: carsList) {
            if (car.isRented()) {
                rentedCarsList.add(car);
            }
        }
        if (rentedCarsList.isEmpty()) {
            ra.addFlashAttribute("warningMessage", "There is currently no rented car");
        }
        model.addAttribute("carsList", rentedCarsList);
        return "redirect:/cars";
    }

    /**
     * Changer l'attribut "loué" à "true" pour indiquer qu'une voiture est louée
     * @param id de la voiture
     * @param ra pour afficher un message de succès (voiture louée) ou d'information (voiture déjà louée)
     * @return l'attribut "loué" de la voiture est sauvegardé à "true" et affiché comme tel dans la BD et la page
     */
    @GetMapping("/cars/rent/{id}")
    public String rentCar(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            Car car = carService.getById(id);
            if (car.isRented()) {
                ra.addFlashAttribute("warningMessage",
                        "You are not allowed to rent a car that is already rented");
            } else {
                car.setRented(true);
                carService.save(car);
                ra.addFlashAttribute("successMessage", "The car has been rented successfully ");
            }
        } catch (CarNotFoundException e) {
            ra.addFlashAttribute("warningMessage", e.getMessage());
        }
        return "redirect:/cars";
    }

    /**
     * Changer l'attribut "loué" à "false" pour indiquer qu'une voiture louée est retournée
     * @param id de la voiture
     * @param ra pour afficher un message de succès (voiture retournée) ou d'information (voiture déjà retournée)
     * @return l'attribut "loué" de la voiture est sauvegardé à "false" et affiché comme tel dans la BD et la page
     */
    @GetMapping("/cars/return/{id}")
    public String returnCar(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            Car car = carService.getById(id);
            if (car.isRented()) {
                car.setRented(false);
                carService.save(car);
                ra.addFlashAttribute("successMessage", "The car has been returned successfully ");
            } else {
                ra.addFlashAttribute("warningMessage",
                        "You are not allowed to return a car that is not rented");
            }
        } catch (CarNotFoundException e) {
            ra.addFlashAttribute("warningMessage", e.getMessage());
        }
        return "redirect:/cars";
    }

    /**
     * Afficher le formulaire pour ajouter une nouvelle voiture
     * @param model pour transmettre le titre de la page et un objet de type "Car" au formulaire html
     * @return l'affichage du formulaire à compléter pour ajouter une nouvelle voiture
     */
    @GetMapping("/cars/new")
    public String showNewForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("pageTitle", "Add new car");
        return "car_form";
    }

    /**
     * Sauvegarder une voiture
     * @param car pour transmettre les informations de la voiture à sauvegarder
     * @param ra pour afficher un message de succès (voiture sauvegardée)
     * @return la sauvegarde de la voiture dans la BD et son affichage sur la page
     */
    @PostMapping("/cars/save")
    public String saveCar(Car car, RedirectAttributes ra) {
        carService.save(car);
        ra.addFlashAttribute("successMessage", "The car has been saved successfully");
        return "redirect:/cars";
    }

    /**
     * Afficher le formulaire pour modifier les informations d'une voiture
     * @param id de la voiture à modifier
     * @param model  pour transmettre le titre de la page et les informations de la voiture au formulaire html
     * @param ra pour afficher un message d'erreur (voiture qui n'existe pas)
     * @return l'affichage du formulaire à compléter pour modifier les informations de la voiture
     */
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

    /**
     * Supprimer une voiture
     * @param id de la voiture à supprimer
     * @param ra pour afficher un message d'erreur (voiture qui n'existe pas)
     * @return la suppression de la voiture dans la BD et au niveau de l'affichage dans la page
     */
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

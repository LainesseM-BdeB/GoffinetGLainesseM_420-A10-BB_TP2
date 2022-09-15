package app.service;

import app.model.Car;
import app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> list() {return carRepository.findAll();}

    public void rent(Integer id, String action) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(
                        "Aucune voiture avec l'id: " + id
                )
        );

        if (action.equals("RENT")) {
            car.setRented(true);
        } else if (action.equals("RETURN")) {
            car.setRented(false);
        } else {
            throw new IllegalStateException("L'action est requise");
        }

    }

}

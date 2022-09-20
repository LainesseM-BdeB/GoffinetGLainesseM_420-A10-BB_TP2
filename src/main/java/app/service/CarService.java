package app.service;

import app.model.Car;
import app.repository.CarRepository;
import app.utils.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Classe "service" des voitures pour les manipulations en BD
 */
@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> listAll() {return carRepository.findAll();}

    public void save(Car car) {
        carRepository.save(car);
    }

    public Car getById(Integer id) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return car.get();
        } else {
            throw new CarNotFoundException("There is no car with the id " + id);
        }
    }


    public void delete(Integer id)  throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            carRepository.delete(car.get());
        } else {
            throw new CarNotFoundException("There is no car with the id " + id);
        }
    }
}

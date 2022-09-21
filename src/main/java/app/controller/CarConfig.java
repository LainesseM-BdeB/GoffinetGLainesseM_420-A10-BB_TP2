package app.controller;

import app.model.Car;
import app.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner commandLineRunner (CarRepository carRepository) {
        return args -> {
            Car car1 = new Car
                    ("Nissan Rogue", 2020, 39000, "6KL BBQ", 33000, false);
            Car car2 = new Car
                    ("Hyundai Ioniq", 2022, 4000, "RE3 NO6", 54000, false);
            Car car3 = new Car
                    ("Infiniti Q60", 2022, 1000, "5MN 97G", 60000, false);
            Car car4 = new Car
                    ("Infiniti QX50", 2021, 10000, "HI8 75X", 62000, false);
            Car car5 = new Car
                    ("Volvo S90", 2018, 24000, "HS2 LK0", 44000, false);
            Car car6 = new Car
                    ("Mercedes G 550", 2016, 56000, "88X 9GA", 48000, false);
            Car car7 = new Car
                    ("Toyota Corolla", 2014, 52000, "P0X 1V1", 29000, false);
            Car car8 = new Car
                    ("Volvo V60", 2020, 12000, "H5I WO6", 31000, false);
            Car car9 = new Car
                    ("Audi A6", 2020, 4500, "UY0 14S", 39000, false);
            Car car10 = new Car
                    ("Toyota RAV4", 2011, 175000, "M2H 8RV", 32000, false);
            Car car11 = new Car
                    ("Mercedes CLS 450", 2015, 90000, "53X P3N", 53000, false);
            Car car12 = new Car
                    ("Tesla Model 3", 2022, 5000, "H5U 9JH", 43000, false);
            Car car13 = new Car
                    ("Dodge Caravan", 2012, 180000, "N6U 45H", 20000, false);
            Car car14 = new Car
                    ("Pontiac Vibe", 2013, 150000, "LW7 MF4", 23000, false);
            Car car15 = new Car
                    ("Nissan Cube", 2016, 100500, "93N LR5", 36000, false);
            Car car16 = new Car
                    ("Honda Civic", 2019, 41000, "JU5 9V9", 27000, false);
            Car car17 = new Car
                    ("Porsche Carrera", 2019, 45000, "2M8 99X", 66000, false);
            Car car18 = new Car
                    ("Ford Escort", 2009, 235000, "YXC AS9", 1200, false);
            Car car19 = new Car
                    ("Nissan Altima", 2011, 190000, "1X2 5EN", 30000, false);
            Car car20 = new Car
                    ("Hyundai Accent", 2010, 205000, "3ER 9L3", 6000, false);

            carRepository.saveAll(List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10,
                    car11, car12, car13, car14, car15, car16, car17, car18, car19, car20));
        };
    }
}

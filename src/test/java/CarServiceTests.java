import app.model.Car;
import app.repository.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CarServiceTests {

    @Test
    public void testListAll() {
//        List<Car> cars = carRepository.findAll();
//        Assertions.assertThat(cars).hasSizeGreaterThan(0);
//        for (Car car: cars) {
//            System.out.println(car);
//        }
    }

    @Test
    public void testSave() {
    }


}

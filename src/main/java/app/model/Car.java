package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private Integer year;
    private Integer mileage;
    private boolean isRented;
    private String model;
    private String license;
    private Integer price;

    public Car() {
    }

    public Car(Integer productId, Integer year, Integer mileage, String model, String license, Integer price) {
        this.productId = productId;
        this.year = year;
        this.mileage = mileage;
        this.isRented = false;
        this.model = model;
        this.license = license;
        this.price = price;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public boolean isRented() {
        return isRented;
    }

    public String getModel() {
        return model;
    }

    public String getLicense() {
        return license;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "productId=" + productId +
                ", year=" + year +
                ", mileage=" + mileage +
                ", isRented=" + isRented +
                ", model='" + model + '\'' +
                ", license='" + license + '\'' +
                ", price=" + price +
                '}';
    }
}

package app.model;

import javax.persistence.*;

/**
 * Classe entité pour l'objet "voiture"
 */
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false, length = 15)
    private String model;

    @Column(nullable = false, length = 4)
    private Integer year;

    @Column(nullable = false, length = 10)
    private Integer mileage;

    @Column(nullable = false,length = 7)
    private String license;

    @Column(nullable = false, length = 10)
    private Integer price;

    @Column(nullable = false, name = "is_rented")
    private boolean rented;

    public Car() {
    }

    public Car(String model, Integer year, Integer mileage, String license, Integer price, boolean rented) {
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.license = license;
        this.price = price;
        this.rented = rented;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Car{" +
                "productId=" + productId +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", license='" + license + '\'' +
                ", price=" + price +
                ", rented=" + rented +
                '}';
    }
}

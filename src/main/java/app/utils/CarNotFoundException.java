package app.utils;

/**
 * Exception personnalisée pour les voitures qui n'existent pas dans la BD
 */
public class CarNotFoundException extends Exception {
    public CarNotFoundException(String message) {
        super(message);
    }
}

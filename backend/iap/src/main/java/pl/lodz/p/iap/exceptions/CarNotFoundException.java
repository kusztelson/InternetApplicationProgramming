package pl.lodz.p.iap.exceptions;

public class CarNotFoundException extends ItemNotFoundException {

    public CarNotFoundException(Long id, String path) {
        super("Car with id %d not found".formatted(id), path, "Car not found");
    }
}

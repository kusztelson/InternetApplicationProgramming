package pl.lodz.p.iap.exceptions;

public class UserNotFoundException extends ItemNotFoundException {

    public UserNotFoundException(Long id, String path) {
        super("User with id %d not found".formatted(id), path, "User not found");
    }
}

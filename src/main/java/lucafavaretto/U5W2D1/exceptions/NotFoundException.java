package lucafavaretto.U5W2D1.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Element with id " + id + " not found");
    }
}

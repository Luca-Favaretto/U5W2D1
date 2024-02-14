package lucafavaretto.U5W2D1.exeptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Element with id " + id + " not found");
    }
}

package lucafavaretto.U5W2D1.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super("Error caused by: " + message);
    }
}

package lucafavaretto.U5W2D1.exeptions;

public class NotFoundElement extends RuntimeException {
    public NotFoundElement(long id) {
        super("Element with id " + id + " not found");
    }
}

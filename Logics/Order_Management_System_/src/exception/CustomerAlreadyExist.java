package exception;

public class CustomerAlreadyExist extends RuntimeException {
    public CustomerAlreadyExist() {
        super("Customer already exists");
    }
}

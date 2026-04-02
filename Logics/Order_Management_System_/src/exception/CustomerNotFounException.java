package exception;

public class CustomerNotFounException extends RuntimeException {
    public CustomerNotFounException(String custId) {
        super("Customer Not Found: " + custId);
    }
}

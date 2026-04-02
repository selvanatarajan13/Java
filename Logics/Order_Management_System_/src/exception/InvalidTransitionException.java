package exception;

import enums.OrderStatus;

public class InvalidTransitionException extends RuntimeException {
    public InvalidTransitionException(OrderStatus from, OrderStatus to) {
        super("Invalid transition: " + from.label() + " → " + to.label());
    }
}

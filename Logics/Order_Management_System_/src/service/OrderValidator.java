package service;

import enums.OrderStatus;
import enums.PaymentStatus;
import exception.DuplicateOrderException;
import exception.InvalidPaymentException;
import exception.OrderNotFoundException;
import model.Order;

public class OrderValidator {

    public void validateNotDuplicate(String orderId, boolean exists) {
        if (exists) throw new DuplicateOrderException(orderId);
    }

    public void validateExists(String orderId, Order order) {
        if (order == null) throw new OrderNotFoundException(orderId);
    }

    public void validateCancellable(Order order) {
        if (order.getPaymentStatus() == PaymentStatus.PAID &&
                order.getOrderStatus()   == OrderStatus.ORDER_DELIVERED) {
            throw new InvalidPaymentException(
                    "Cannot cancel a delivered order: " + order.getOrderId());
        }
    }
}

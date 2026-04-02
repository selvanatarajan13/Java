package enums;

public enum OrderStatus {
    ORDER_CREATED,
    ORDER_PAID,
    ORDER_SHIPPED,
    ORDER_DELIVERED,
    ORDER_CANCELLED;

    public boolean canTransitionTo(OrderStatus next) {
        return switch (this) {
            case ORDER_CREATED   -> next == ORDER_PAID || next == ORDER_CANCELLED;
            case ORDER_PAID      -> next == ORDER_SHIPPED || next == ORDER_CANCELLED;
            case ORDER_SHIPPED   -> next == ORDER_DELIVERED;
            case ORDER_DELIVERED -> false;
            case ORDER_CANCELLED -> false;
        };
    }

    public String label() {
        return switch (this) {
            case ORDER_CREATED   -> "Order Created";
            case ORDER_PAID      -> "Payment Done";
            case ORDER_SHIPPED   -> "Out for Delivery";
            case ORDER_DELIVERED -> "Delivered";
            case ORDER_CANCELLED -> "Cancelled";
        };
    }
}

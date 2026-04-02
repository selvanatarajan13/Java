package enums;

public enum PaymentStatus {
    PAID, NOT_PAID, REFUNDED;

    public String label() {
        return switch (this) {
            case PAID     -> "Paid";
            case NOT_PAID -> "Pending";
            case REFUNDED -> "Refunded";
        };
    }
}

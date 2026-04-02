package payment;

public class CODPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.printf("✅ COD of ₹%.2f — Will be collected on delivery!%n", amount);
        return true;
    }

    @Override
    public String methodName() {
        return "Cash on Delivery";
    }
}

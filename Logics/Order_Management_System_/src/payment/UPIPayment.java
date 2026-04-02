package payment;

public class UPIPayment implements PaymentStrategy {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("✅ UPI Payment of ₹%.2f via %s — Success!%n", amount, upiId);
        return true;
    }

    @Override
    public String methodName() {
        return "UPI (" + upiId + ")";
    }
}

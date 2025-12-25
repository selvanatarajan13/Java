package paymentDomain;

public class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid by cash: " + amount);
    }
}

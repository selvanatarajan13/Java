package dto;

public class PaymentDetail {
    int paymentOption;
    String PaymentMethod;
    double amount;

    public PaymentDetail(int paymentOption, String paymentMethod, double amount) {
        this.paymentOption = paymentOption;
        PaymentMethod = paymentMethod;
        this.amount = amount;
    }

    public int getPaymentOption() {
        return paymentOption;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public double getAmount() {
        return amount;
    }
}

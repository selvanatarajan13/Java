package service;

import paymentDomain.PaymentMethod;

public class PaymentService {

    // Abstract method
    public void makePayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}

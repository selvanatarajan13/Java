package payment;

public class CardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }


    @Override
    public boolean pay(double amount) {
        System.out.printf("✅ Card Payment of ₹%.2f by %s (****%s) — Success!%n",
                amount, cardHolder, cardNumber.substring(cardNumber.length() - 4));
        return true;
    }

    @Override
    public String methodName() {
        return "Card (" + cardHolder + ")";
    }
}

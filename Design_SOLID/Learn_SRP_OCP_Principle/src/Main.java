import dto.PaymentDetail;
import paymentDomain.CardPayment;
import paymentDomain.CashPayment;
import paymentDomain.PaymentMethod;
import service.PaymentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("PaymentService Starting");
        Payment();
        System.out.println("PaymentService End");
    }

    /**
     * Returns a generic type T that extends PaymentMethod.
     * The cast to (T) is required because switch expressions return a
     * specific implementation, but the method promises any T.
     */
    @SuppressWarnings("unchecked")
    public static <T extends PaymentMethod> T getPaymentMethod(int paymentType) {
        return (T) switch (paymentType) {
            case 1 -> new CardPayment();
            case 2 -> new CashPayment();
            default -> new CashPayment();
        };
    }

    public static void Payment() {
        PaymentDetail paymentDetail = Display();
        try {
            PaymentMethod method = getPaymentMethod(paymentDetail.getPaymentOption());
            PaymentService service = new PaymentService();
            service.makePayment(method, paymentDetail.getAmount());
        } catch (Exception e) {
            System.err.printf("Error: %s%n", e.getMessage());
        }
    }

    public static PaymentDetail Display() {

        Scanner scanner = new Scanner(System.in);

        // 1. Using a Text Block (Java 15+) for a clean menu
        String menu = """
                \n
                ===============================================
                            Select Payment Method
                ===============================================
                [1] Card Payment
                [2] Cash Payment
                ----------------------------------------------
                \n
                """;
        System.out.println(menu);

        System.out.println("Enter Payment Option: ");
        int option = scanner.nextInt();

        String paymentMethod = switch (option) {
            case 1 -> "Card";
            case 2 -> "Cash";
            default -> "Cash";
        };

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();

        String confirmMessage = """
                ===============================================
                            Payment Confirmation
                ===============================================
                Payment method  : %s
                Amount          : $%,.2f
                ----------------------------------------------
                """.formatted(paymentMethod, amount);

        System.out.println(confirmMessage);
        PaymentDetail detail = new PaymentDetail(option, paymentMethod, amount);
        scanner.close();
        return detail;
    }
}
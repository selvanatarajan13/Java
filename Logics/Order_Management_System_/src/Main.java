import decorator.ExpressDeliveryDecorator;
import decorator.GiftWrapDecorator;
import enums.ProductCategory;
import factory.ProductFactory;
import model.Customer;
import model.Order;
import model.product.Electronics;
import model.product.Product;
import payment.CODPayment;
import payment.CardPayment;
import payment.UPIPayment;
import service.OrderService;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n========== ORDER MANAGEMENT SYSTEM ==========\n");

        // ===== Singleton =====
        OrderService service  = OrderService.getInstance();
        OrderService service2 = OrderService.getInstance();
        System.out.println("Singleton proof: " + service.isSameInstance(service2));

        // ===== Factory Pattern — create products =====
        Product iPhone  = ProductFactory.create(ProductCategory.ELECTRONICS,
                "P01", "iPhone 16", 96000, "Apple", "12");
        Product shirt   = ProductFactory.create(ProductCategory.CLOTHING,
                "P02", "Cotton Shirt", 499, "M", "Blue");
        Product milk    = ProductFactory.create(ProductCategory.GROCERY,
                "P03", "Amul Milk", 60, "Amul", "2025-06-01");
        Product macBook = ProductFactory.create(ProductCategory.ELECTRONICS,
                "P04", "MacBook Air", 120000, "Apple", "24");

        // ===== Decorator Pattern — add-ons =====
        Product iPhoneGifted   = new GiftWrapDecorator(iPhone);
        Product macBookExpress = new ExpressDeliveryDecorator(macBook);
        Product macBookBoth    = new GiftWrapDecorator(
                new ExpressDeliveryDecorator(macBook)); // stack decorators!

        System.out.println("\n===== PRODUCT PRICES =====");
        System.out.println(iPhone        + " → Final: ₹" + iPhone.getFinalPrice());
        System.out.println(iPhoneGifted  + " → Final: ₹" + iPhoneGifted.getFinalPrice());
        System.out.println(macBookBoth   + " → Final: ₹" + macBookBoth.getFinalPrice());

        // ===== Customers =====
        Customer bob   = new Customer("C01", "Bob",   "9787660170", "Nagercoil");
        Customer alice = new Customer("C02", "Alice", "9876543210", "Chennai");
        Customer ram   = new Customer("C03", "Ram",   "9123456789", "Madurai");

        // ===== Place Orders =====
        System.out.println("\n===== PLACING ORDERS =====");
        Order o1 = service.placeOrder("ORD001", bob,   iPhoneGifted);
        Order o2 = service.placeOrder("ORD002", bob,   macBookExpress);
        Order o3 = service.placeOrder("ORD003", alice, shirt);
        Order o4 = service.placeOrder("ORD004", alice, milk);
        Order o5 = service.placeOrder("ORD005", ram,   macBook,
                "SAVE10", true); // Builder with options

        // ===== Strategy Pattern — different payment methods =====
        System.out.println("\n===== PAYMENTS =====");
        service.makePayment("ORD001", new UPIPayment("bob@upi"));
        service.makePayment("ORD003", new CardPayment("4111111111111234", "Alice"));
        service.makePayment("ORD005", new CODPayment());

        // ===== State Machine — ship and deliver =====
        System.out.println("\n===== SHIPPING & DELIVERY =====");
        service.shipOrder("ORD001");
        service.deliverOrder("ORD001");

        // ===== Invalid transition test =====
        System.out.println("\n===== INVALID TRANSITION TEST =====");
        try {
            service.cancelOrder("ORD001"); // Already delivered — should throw
        } catch (exception.InvalidTransitionException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ===== DSA: Top 3 Expensive =====
        System.out.println("\n===== TOP 3 EXPENSIVE ORDERS (Heap) =====");
        service.getTopNExpensive(3)
                .forEach(o -> System.out.printf("  ₹%.2f — %s%n",
                        o.getProduct().getFinalPrice(),
                        o.getProduct().getProductName()));

        // ===== DSA: Sorted by price =====
        System.out.println("\n===== ORDERS SORTED BY PRICE =====");
        service.getAllSortedByPrice()
                .forEach(o -> System.out.printf("  ₹%.2f — %s%n",
                        o.getProduct().getFinalPrice(),
                        o.getProduct().getProductName()));

        // ===== DSA: Grouped by status =====
        System.out.println("\n===== ORDERS GROUPED BY STATUS =====");
        service.groupByStatus().forEach((status, orders) -> {
            System.out.println("\n[ " + status + " ]");
            orders.forEach(o -> System.out.println("  → " + o));
        });

        // ===== Customer history =====
        System.out.println("\n===== CUSTOMER HISTORIES =====");
        bob.showOrderHistory();
        bob.showTotalSpent();
        alice.showOrderHistory();
        alice.showTotalSpent();

        // ===== Revenue Report =====
        service.showRevenueReport();
    }
}
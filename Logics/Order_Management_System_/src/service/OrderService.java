package service;

import enums.PaymentStatus;
import exception.OrderNotFoundException;
import model.AuditLog;
import model.Customer;
import model.Order;
import model.product.Product;
import payment.PaymentStrategy;
import repository.OrderRepository;

import java.util.List;
import java.util.Map;

public class OrderService {
    // ===== Singleton =====
    private static OrderService instance;

    private final OrderRepository orderRepository;
    private final OrderValidator validator;
    private final OrderNotifier notifier;
    private final AuditLog auditLog;

    public OrderService() {
        this.orderRepository = new OrderRepository();
        this.validator = new OrderValidator();
        this.notifier = new OrderNotifier();
        this.auditLog = new AuditLog();
    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    // ===== Place Order =====
    public Order placeOrder(String orderId, Customer customer, Product product) {

        // Validate — SRP
        validator.validateNotDuplicate(orderId, orderRepository.findById(orderId).isPresent());

        // Build — Builder Pattern
        Order order = new Order.Builder(orderId, customer, product)
                .withDeliveryAddress(customer.getPlace())
                .build();

        // Observer — customer gets SMS on every status change
        order.addOberser(customer);

        // Save — Repository
        orderRepository.save(order);

        // Link to customer history
        customer.addOrder(order);

        // Notify + Log — SRP
        notifier.notifyPlaced(order);
        auditLog.log("Order placed: " + orderId +
                " | Customer: " + customer.getCustomerName() +
                " | Product: " + product.getProductName());

        return order;
    }

    // ===== Place Order with full options (Builder) =====
    public Order placeOrder(String orderId, Customer customer, Product product, String coupon, boolean giftWrap) {

        validator.validateNotDuplicate(orderId, orderRepository.findById(orderId).isPresent());

        Order order = new Order.Builder(orderId, customer, product)
                .withDeliveryAddress(customer.getPlace())
                .withCoupon(coupon)
                .withGiftWrap(giftWrap)
                .build();

        orderRepository.save(order);
        order.addOberser(customer);
        customer.addOrder(order);
        notifier.notifyPlaced(order);
        auditLog.log("Order placed (with options): " + orderId);

        return order;
    }

    // ===== Make a Payment — Strategy Pattern =====
    public void makePayment(String orderId, PaymentStrategy strategy) {
        Order order = findByIdOrThrow(orderId);
        order.makePayment(strategy); // Strategy pattern inside order
        auditLog.log("Payment done: " + orderId + " via " + strategy.methodName());
    }

    public void cancelOrder(String orderId) {
        Order order = findByIdOrThrow(orderId);
        validator.validateCancellable(order);
        order.cancelOrder();
        notifier.notifyCancelled(order);
        auditLog.log("Order cancelled: " + orderId);
    }

    // ===== Ship Order =====
    public void shipOrder(String orderId) {
        Order order = findByIdOrThrow(orderId);
        order.shipOrder();
        notifier.notifyShipped(order);
        auditLog.log("Order shipped: " + orderId);
    }

    // ===== Deliver Order =====
    public void deliverOrder(String orderId) {
        Order order = findByIdOrThrow(orderId);
        order.deliverOrder();
        auditLog.log("Order delivered: " + orderId);
    }

    // ===== Undo Last Order — Stack DSA =====
    public void undoLastOrder() {
        orderRepository.undoLastOrder().ifPresentOrElse(
                o -> auditLog.log("Undo: removed order " + o.getOrderId()),
                () -> System.out.println("Nothing to undo."));
    }

    // ===== DSA Operations =====
    public List<Order> getTopNExpensive(int n)  { return orderRepository.getTopNExpensive(n); }
    public List<Order> getAllSortedByPrice()     { return orderRepository.getSortedByPrice(); }
    public List<Order> findByCustomer(String id){ return orderRepository.findByCustomerId(id); }
    public Map<String, List<Order>> groupByStatus() { return orderRepository.groupByStatus(); }

    // ===== Revenue Report — Stream aggregation =====
    public void showRevenueReport() {
        List<Order> all = orderRepository.findAll();
        double revenue = all.stream()
                .filter(o -> o.getPaymentStatus() == PaymentStatus.PAID)
                .mapToDouble(o -> o.getProduct().getFinalPrice())
                .sum();
        long paid      = all.stream().filter(o -> o.getPaymentStatus() == PaymentStatus.PAID).count();
        long unpaid    = all.stream().filter(o -> o.getPaymentStatus() == PaymentStatus.NOT_PAID).count();

        System.out.println("\n========== REVENUE REPORT ==========");
        System.out.println("Total Orders  : " + all.size());
        System.out.println("Paid Orders   : " + paid);
        System.out.println("Unpaid Orders : " + unpaid);
        System.out.printf( "Total Revenue : ₹%.2f%n", revenue);
        System.out.println("=====================================");
    }

    public void showAllOrders() {
        System.out.println("\n========== ALL ORDERS ==========");
        orderRepository.findAll().forEach(o -> System.out.println("  → " + o));
    }

    // ===== Helper =====
    private Order findByIdOrThrow(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    // ===== Singleton proof =====
    public boolean isSameInstance(OrderService other) {
        return this == other;
    }
}

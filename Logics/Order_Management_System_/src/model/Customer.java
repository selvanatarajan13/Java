package model;

import enums.PaymentStatus;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Observer {
    private String customerID;
    private String customerName;
    private String mobileNo;
    private String place;
    private List<Order> orderHistory;

    public Customer(String customerID, String customerName, String mobileNo, String place) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.mobileNo = mobileNo;
        this.place = place;
        this.orderHistory = new ArrayList<>();
    }

    @Override
    public void update(Order order) {
        System.out.println("📱 SMS to " + customerName +
                " (" + mobileNo + "): Your order " +
                order.getOrderId() + " is now → " +
                order.getOrderStatus().label());
    }

    public void addOrder(Order order) {
        this.orderHistory.add(order);
    }

    // DSA: Stream filter
    public void showOrderHistory() {
        System.out.println("\n--- " + customerName + "'s Order History ---");
        if (orderHistory.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }
        orderHistory.forEach(o -> System.out.println("  → " + o));
    }

    // DSA: Stream + reduce — total amount spent
    public void showTotalSpent() {
        double total = orderHistory.stream()
                .filter(o -> o.getPaymentStatus() == PaymentStatus.PAID)
                .mapToDouble(o -> o.getProduct().getFinalPrice())
                .sum();

        System.out.printf("💰 Total spent by %s: ₹%.2f%n", customerName, total);
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getPlace() {
        return place;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
}

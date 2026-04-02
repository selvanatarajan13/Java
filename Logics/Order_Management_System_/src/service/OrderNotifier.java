package service;

import model.Order;

public class OrderNotifier {

    public void notifyPlaced(Order order) {
        System.out.println("📧 Email: Order " + order.getOrderId() +
                " placed for " + order.getCustomer().getCustomerName());
    }

    public void notifyCancelled(Order order) {
        System.out.println("📧 Email: Order " + order.getOrderId() +
                " has been cancelled.");
    }

    public void notifyShipped(Order order) {
        System.out.println("📧 Email: Order " + order.getOrderId() +
                " has been shipped to " + order.getDeliveryAddress());
    }
}

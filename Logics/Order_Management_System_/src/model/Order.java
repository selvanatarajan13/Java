package model;

import enums.OrderStatus;
import enums.PaymentStatus;
import exception.InvalidTransitionException;
import model.product.Product;
import observer.Observer;
import payment.PaymentStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private Product product;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private String deliveryAddress;
    private String couponCode;
    private boolean giftWrap;
    private LocalDateTime createdAt;

    // Observer list — notified on status change
    private List<Observer> observers;

    public Order() {
        this.observers   = new ArrayList<>();
        this.orderStatus = OrderStatus.ORDER_CREATED;
        this.paymentStatus = PaymentStatus.NOT_PAID;
        this.createdAt   = LocalDateTime.now();
    }

    // ========== Builder Pattern ==========
    public static class Builder {
        private String orderId;
        private Customer customer;
        private Product product;
        private String deliveryAddress = "";
        private String couponCode = "";
        private boolean giftWrap = false;

        public Builder(String orderId, Customer customer, Product product) {
            this.orderId = orderId;
            this.customer = customer;
            this.product = product;
        }

        public Builder withDeliveryAddress(String address) {
            this.deliveryAddress = address;
            return this;
        }

        public Builder withCoupon(String couponCode) {
            this.couponCode = couponCode;
            return this;
        }

        public Builder withGiftWrap(boolean isWantGiftWrap) {
            this.giftWrap = isWantGiftWrap;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.orderId          = this.orderId;
            order.customer         = this.customer;
            order.product          = this.product;
            order.deliveryAddress  = this.deliveryAddress;
            order.couponCode       = this.couponCode;
            order.giftWrap         = this.giftWrap;
            return order;
        }
    }

    // ========== Observer Pattern ==========
    public void addOberser(Observer o) {
        observers.add(o);
    }

    private void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    // ========== State Machine ==========
    public void transitionTo(OrderStatus newStatus) {
        if (!this.orderStatus.canTransitionTo(newStatus)) {
            throw new InvalidTransitionException(this.orderStatus, newStatus);
        }
        this.orderStatus = newStatus;
        notifyObservers(); // Observer Pattern — notify on every status change
    }

    // ========== Strategy Pattern ==========
    public void makePayment(PaymentStrategy strategy) {
        double amount = product.getFinalPrice();
        boolean success = strategy.pay(amount);
        if (success) {
            this.paymentStatus = PaymentStatus.PAID;
            transitionTo(OrderStatus.ORDER_PAID);
        }
    }

    public void shipOrder()    { transitionTo(OrderStatus.ORDER_SHIPPED); }
    public void deliverOrder() { transitionTo(OrderStatus.ORDER_DELIVERED); }
    public void cancelOrder()  { transitionTo(OrderStatus.ORDER_CANCELLED); }

    public String getOrderId()           { return orderId; }
    public Customer getCustomer()        { return customer; }
    public Product getProduct()          { return product; }
    public OrderStatus getOrderStatus()  { return orderStatus; }
    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public String getDeliveryAddress()   { return deliveryAddress; }
    public String getCouponCode()        { return couponCode; }
    public boolean isGiftWrap()          { return giftWrap; }
    public LocalDateTime getCreatedAt()  { return createdAt; }

    @Override
    public String toString() {
        return String.format(
                "Order{id='%s', customer='%s', product='%s', status='%s', payment='%s', address='%s'}",
                orderId, customer.getCustomerName(), product.getProductName(),
                orderStatus.label(), paymentStatus.label(), deliveryAddress);
    }
}

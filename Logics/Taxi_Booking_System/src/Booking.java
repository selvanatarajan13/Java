public class Booking {
    private final int bookingId;
    private final Customer customer;
    private final Location pickupPoint;
    private final Location dropPoint;
    private final int pickupTime;

    private Taxi assignTaxi;
    private double fare;
    private BookingStatus status;

    public Booking(int bookingId, Customer customer, Location pickupPoint, Location dropPoint, int pickupTime) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
    }

    public void confirm(Taxi taxi, double fare) {
        this.assignTaxi = taxi;
        this.fare = fare;
        this.status = BookingStatus.CONFIRMED;
    }

    public void reject() {
        this.assignTaxi = null;
        this.fare = 0;
        this.status = BookingStatus.REJECTED;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Location getPickupPoint() {
        return pickupPoint;
    }

    public Location getDropPoint() {
        return dropPoint;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public Taxi getAssignTaxi() {
        return assignTaxi;
    }

    public double getFare() {
        return fare;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }
}

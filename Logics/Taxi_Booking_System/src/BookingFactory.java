import java.util.concurrent.atomic.AtomicInteger;

public class BookingFactory {

    private final AtomicInteger bookingCounter = new AtomicInteger(1001);

    public Booking create(Customer customer, Location pickup, Location drop, int pickupTime) {
        return new Booking(bookingCounter.getAndIncrement(), customer, pickup, drop, pickupTime);
    }
}

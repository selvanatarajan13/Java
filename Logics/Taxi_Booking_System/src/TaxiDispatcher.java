import java.util.Comparator;
import java.util.List;

public class TaxiDispatcher {

    private final List<Taxi> taxis;
    private final FareCalculator fareCalculator;

    public TaxiDispatcher(List<Taxi> taxis, FareCalculator fareCalculator) {
        this.taxis = taxis;
        this.fareCalculator = fareCalculator;
    }

    public void BookTaxi(Booking booking) {
        if (booking == null) {
            System.out.println("Booking error, please try again later...");
        }

        Taxi selectedTaxi = this.processBooking(booking);

        if (selectedTaxi == null) {
            booking.reject();
            System.out.println("No taxis are available at this time, please try again later");
            return;
        }

        int tripDistance = booking.getPickupPoint().distanceTo(booking.getDropPoint());
        double fare = fareCalculator.calculateFare(tripDistance);
        int tripDuration = booking.getPickupPoint().travelTimeTo(booking.getDropPoint());
        int tripEndTime = booking.getPickupTime() + tripDuration;

        selectedTaxi.assignTrip(booking.getDropPoint(), tripEndTime, fare);
        booking.confirm(selectedTaxi, fare);
        TripRecord record = new TripRecord(booking.getBookingId(), booking.getCustomer().getId(), booking.getPickupPoint(), booking.getDropPoint(),booking.getPickupTime(), tripEndTime, fare);
        selectedTaxi.addBooking(record);

        System.out.println("\nBooking ID: " + booking.getBookingId());
        System.out.println("Status: " + booking.getStatus());
        System.out.println("Taxi: " + (booking.getAssignTaxi() != null ? " Taxi-" + booking.getAssignTaxi().getId() + " is allocated" : "None"));
        System.out.println("Fare: " + booking.getFare());
        System.out.println("Booking assigned taxi: " + booking.getAssignTaxi().getId());
        System.out.println("Taxi booking history size: " + selectedTaxi.getTripRecord().size());
    }

    public Taxi processBooking(Booking booking) {
        // Find a free taxi at that time of customer booking
        List<Taxi> freeTaxis = taxis.stream()
                .filter(t -> t.isFree(booking.getPickupPoint(), booking.getPickupTime()))
                .toList();

        // Validation
        if (freeTaxis.isEmpty()) {
            return null;
        }

        // Find the nearest free taxis
        Taxi selectedTaxi = freeTaxis.stream()
                .min(
                        Comparator.comparingInt(
                                        (Taxi t) -> t.getCurrentLocation().distanceTo(booking.getPickupPoint())
                        )
                                .thenComparingDouble(Taxi::getTotalEarnings)
                )
                .orElseThrow();

        return selectedTaxi;
    }

    public void displayBookingTaxiLogs() {
        System.out.println("\n");
        System.out.printf("-".repeat(100));
        System.out.println("\n");
        String taxiNoandTotEarnings = """
                %-10s %-15s %-20s
                """.formatted("Taxi No: ", "Total Earnings: ", "No.records: ");
        System.out.println(taxiNoandTotEarnings);
        String header = """
                %-10s %-15s %-10s %-10s %-10s %-10s %-10s
                """.formatted("BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount");
        System.out.println(header);
        System.out.printf("-".repeat(100));
        System.out.println("\n");

        for (Taxi taxi: taxis) {
            int size = taxi.getTripRecord().size();
            String taxiEarningsRecords = """
                    %-10s %-15s %-20s
                    """.formatted("Taxi-" + taxi.getId(), taxi.getTotalEarnings(), size);
            System.out.println(taxiEarningsRecords);
//            System.out.println("Taxi id: " + taxi.getId() + " have " + size + " records");
//            System.out.println("Taxi id: " + taxi.getId() + " total earning: " + taxi.getTotalEarnings());
            if (size > 0) {
                for (TripRecord record: taxi.getTripRecord()) {
                    String data = """
                            %-10s %-15s %-10s %-10s %-10s %-10s %-10s
                            """.formatted(record.bookingId(), record.CustomerId(), record.pickupPoint(), record.dropPoint(), record.pickupTime(), record.tripEndTime(), record.fare());
                    System.out.println(data);
                }
                System.out.printf("-".repeat(100));
                System.out.println("\n");
            }
        }
    }
}

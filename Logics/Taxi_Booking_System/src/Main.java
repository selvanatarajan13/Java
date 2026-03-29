import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Taxi Booking System");

        // Factories
        Factory taxiFactory = new TaxiFactory();
        TaxiFleetFactory fleetFactory = new TaxiFleetFactory(taxiFactory);
        BookingFactory bookingFactory = new BookingFactory();

        // create Taxis
        List<Taxi> taxiList = fleetFactory.createFleet(4);

        // Inject fare strategy
        FareCalculator fareCalculator = new NormalFareCalculator();

        TaxiDispatcher dispatcher = new TaxiDispatcher(taxiList, fareCalculator);

        // Customer
        Customer customer1 = new Customer(201, "Mahend");
        Customer customer2 = new Customer(202, "Selva");
        Customer customer3 = new Customer(203, "Mani");

        // create booking using factory
        // Nearest Taxi rule allocation scenario-1
        Booking b1 = bookingFactory.create(customer1, Location.A, Location.B, 9);
        dispatcher.BookTaxi(b1);

        Booking b2 = bookingFactory.create(customer2, Location.B, Location.D, 9);
        dispatcher.BookTaxi(b2);

        Booking b3 = bookingFactory.create(customer3, Location.B, Location.C, 12);
        dispatcher.BookTaxi(b3);

        Booking b4 = bookingFactory.create(customer1, Location.D, Location.F, 12);
        dispatcher.BookTaxi(b4);

        dispatcher.displayBookingTaxiLogs();
//
//        // Tiebreaker (Same distance -> lower earnings) scenario-2
//        Booking t1 = bookingFactory.create(customer1, Location.A, Location.B, 6);
//        dispatcher.BookTaxi(t1);
//
//        Booking t2 = bookingFactory.create(customer2, Location.A, Location.B, 7);
//        dispatcher.BookTaxi(t2);
//
//        Booking b5 = bookingFactory.create(customer3, Location.B, Location.E, 9);
//        dispatcher.BookTaxi(b5);

        // Booking a rejected scenario
//        Booking r1 = bookingFactory.create(customer1, Location.A, Location.F, 9);
//        dispatcher.BookTaxi(r1);
//
//        Booking r2 = bookingFactory.create(customer2, Location.A, Location.F, 9);
//        dispatcher.BookTaxi(r2);
//
//        Booking r3 = bookingFactory.create(customer3, Location.A, Location.F, 9);
//        dispatcher.BookTaxi(r3);
//
//        Booking r4 = bookingFactory.create(new Customer(204, "Kumar"), Location.A, Location.F, 9);
//        dispatcher.BookTaxi(r4);
//
//        Booking r5 = bookingFactory.create(new Customer(205, "Ravi"), Location.B, Location.C, 9);
//        dispatcher.BookTaxi(r5);

        // Fare checking
//        Booking fare1 = bookingFactory.create(customer1, Location.C, Location.D, 10);
//        dispatcher.BookTaxi(fare1);
    }
}
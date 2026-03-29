import domain.ticket.Ticket;
import domain.train.AcCoach;
import domain.train.Coach;
import domain.train.SleeperCoach;
import domain.train.Train;
import domain.user.Passenger;
import domain.user.PassengerType;
import exception.CancellationException;
import service.booking.BookingService;
import service.booking.BookingServiceImpl;
import service.cancellation.CancellationService;
import service.cancellation.CancellationServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Train train = createSampleTrain();

        Passenger passenger1 = new Passenger("Selva", 28, PassengerType.ADULT);
        Passenger passenger2 = new Passenger("Mahendran", 65, PassengerType.SENEIOR_CITIZEN);

        BookingService bookingService = new BookingServiceImpl();
        CancellationService cancellationService = new CancellationServiceImpl();

        Ticket ticket1 = bookingService.bookTicket(train, passenger1);
        System.out.println("Booked Ticket PNR: " + ticket1.getPnr());

        Ticket ticket2 = bookingService.bookTicket(train, passenger2);
        System.out.println("Booked Ticket PNR: " + ticket2.getPnr());

        double fine = cancellationService.cancelTicket(ticket1);
        System.out.println("Ticket cancelled fine: " + fine);

        try {
            double fine2 = cancellationService.cancelTicket(ticket1);
        } catch (CancellationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Train createSampleTrain() {
        List<Coach> coaches = new ArrayList<>();
        coaches.add(new SleeperCoach("S1"));
        coaches.add(new AcCoach("A1"));

        return new Train(
                "12345",
                "Chennai Express",
                "Chennai",
                "Bangalore",
                coaches
        );
    }
}
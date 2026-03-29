package service.booking;

import domain.ticket.Ticket;
import domain.train.Seat;
import domain.train.Train;
import domain.user.Passenger;
import exception.SeatNotAvailableException;
import exception.ValidationException;

public class BookingServiceImpl implements BookingService {

    @Override
    public Ticket bookTicket(Train train, Passenger passenger) {
        // Validate the passenger
        validatePassenger(passenger);

        Seat bookedSeat = null;

        try {
            // Find an available seat
            bookedSeat = train.getCoaches()
                    .stream()
                    .flatMap(coach -> coach.getSeats().stream())
                    .filter(Seat::isAvailable)
                    .findFirst()
                    .orElseThrow(() -> new SeatNotAvailableException("No seats available"));

            // Change state (book seat)
            bookedSeat.book();

            // Create ticket
            Ticket ticket = new Ticket(generatePnrNumber(), train, passenger, bookedSeat);

            return ticket;
        } catch (RuntimeException e) {
            if (bookedSeat != null) {
                bookedSeat.release();
            }

            throw e;
        }
    }

    private void validatePassenger(Passenger passenger) {
        if (passenger == null) {
            throw new ValidationException("Passenger cannot be null");
        }

        if (passenger.getAge() <= 0) {
            throw new ValidationException("Invalid passenger age");
        }
    }

    private String generatePnrNumber() {
        return "PNR-" + System.currentTimeMillis();
    }
}

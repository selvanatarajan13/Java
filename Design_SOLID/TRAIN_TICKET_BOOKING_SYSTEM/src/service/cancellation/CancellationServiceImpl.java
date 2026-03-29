package service.cancellation;

import domain.ticket.Ticket;
import domain.ticket.TicketStatus;
import domain.train.Seat;
import exception.CancellationException;
import exception.ValidationException;

public class CancellationServiceImpl implements CancellationService {

    @Override
    public double cancelTicket(Ticket ticket) {
        // Validate ticket
        validateTicket(ticket);

        Seat seat = ticket.getSeat();

        try {
            double fine = calculateFine(ticket);

            ticket.cancel();

            seat.release();

            return fine;
        } catch (RuntimeException e) {
            // Rollback safety
            // If anything fails, ticket must remain CONFIRMED status
            ticket.restore();

            throw e;
        }
    }

    private void validateTicket(Ticket ticket) {
        if (ticket == null) {
            throw new ValidationException("Ticket can't be null");
        }

        if (ticket.getStatus() == TicketStatus.CANCELLED) {
            throw new CancellationException("Ticket already cancelled");
        }
    }

    private double calculateFine(Ticket ticket) {
        long hoursBeforeDeparture = ticket.hoursBeforeDeparture();

        if (hoursBeforeDeparture > 24) {
            return 50.0;
        } else if (hoursBeforeDeparture > 0) {
            return 100.0;
        } else {
            throw new CancellationException("Cancellation not allowed after departure");
        }
    }
}

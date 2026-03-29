package service.cancellation;

import domain.ticket.Ticket;

public interface CancellationService {
    double cancelTicket(Ticket ticket);
}

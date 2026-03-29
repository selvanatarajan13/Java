package service.booking;

import domain.ticket.Ticket;
import domain.train.Train;
import domain.user.Passenger;

public interface BookingService {
    Ticket bookTicket(Train train, Passenger passenger);
}

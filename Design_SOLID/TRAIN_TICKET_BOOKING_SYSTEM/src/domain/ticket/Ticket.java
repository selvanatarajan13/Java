package domain.ticket;

import domain.train.Seat;
import domain.train.Train;
import domain.user.Passenger;

public class Ticket {
    private final String pnr;
    private final Train train;
    private final Passenger passenger;
    private final Seat seat;
    private TicketStatus status;

    public Ticket(String pnr, Train train, Passenger passenger, Seat seat) {
        this.pnr = pnr;
        this.train = train;
        this.passenger = passenger;
        this.seat = seat;
        this.status = TicketStatus.CONFIRMED;
    }

    public String getPnr() {
        return pnr;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void cancel() {
        this.status = TicketStatus.CANCELLED;
    }

    // rollback support
    public void restore() {
        this.status = TicketStatus.CONFIRMED;
    }

    // mock time logic for now
    public long hoursBeforeDeparture() {
        return 10;
    }

    public Seat getSeat() {
        return seat;
    }
}

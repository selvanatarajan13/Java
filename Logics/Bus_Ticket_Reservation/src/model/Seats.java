package model;

public class Seats {
    private final String seatNo;
    private final SeatType seatType;
    private final Deck deck;
    private final boolean isBooked;

    public Seats(String seatNo, SeatType seatType, Deck deck) {
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.deck = deck;
        this.isBooked = false;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public Deck getDeck() {
        return deck;
    }

    public boolean isBooked() {
        return isBooked;
    }
}

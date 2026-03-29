package domain.train;

public class Seat {
    private final int seatNumber;
    private boolean available;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.available = true;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void book() {
        this.available = false;
    }

    public void release() {
        this.available = true;
    }
}

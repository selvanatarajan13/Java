package domain.train;

import java.util.ArrayList;
import java.util.List;

public abstract class Coach {
    protected final String coachNumber;
    protected final List<Seat> seats;

    protected Coach(String coachNumber, int seatCount) {
        this.coachNumber = coachNumber;
        this.seats = new ArrayList<>();
        for (int i = 0; i <= seatCount; i++) {
            seats.add(new Seat(i));
        }
    }

    public String getCoachNumber() {
        return coachNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public abstract String getCoachType();
}

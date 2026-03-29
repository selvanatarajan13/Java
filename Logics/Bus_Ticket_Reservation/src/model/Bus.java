package model;

import java.util.List;
import java.util.Map;

public class Bus {
    private final int busId;
    private final int departureTime; // absolute time like 6, 9, 15
    private final int arrivalTime;   // departure + 8
    private final Map<String, Seats> seatsMap;

    public Bus(int busId, int departureTime, int arrivalTime, Map<String, Seats> seatsMap) {
        this.busId = busId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatsMap = seatsMap;
    }

    public int getAvailableSeatCount() {
        return (int) seatsMap.values().stream().filter(s -> !s.isBooked()).count();
    }

    public int getBusId() {
        return busId;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public Map<String, Seats> getSeatsMap() {
        return seatsMap;
    }
}

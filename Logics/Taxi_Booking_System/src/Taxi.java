import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private final int id;
    private Location currentLocation;
    private int freeTime;
    private double totalEarnings;
    private List<TripRecord> tripRecord = new ArrayList<>();

    public Taxi(int id) {
        this.id = id;
        this.currentLocation = Location.A;
        this.freeTime = 0;
        this.totalEarnings = 0;
    }

    public boolean isFree(Location pickupPoint, int pickupTime) {
        int travelTime = Math.abs(pickupPoint.getIndex() - this.currentLocation.getIndex());
        return ((this.freeTime + travelTime) <= pickupTime);
    }

    public void assignTrip(Location drop, int dropTime, double fare) {
        this.currentLocation = drop;
        this.freeTime = dropTime;
        this.totalEarnings += fare;
    }

    public void addBooking(TripRecord record) {
        this.tripRecord.add(record);
    }

    public int getId() {
        return id;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public List<TripRecord> getTripRecord() {
        return tripRecord;
    }
}

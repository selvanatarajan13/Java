package pricing;

import domain.user.Passenger;
import domain.user.PassengerType;

public class ACFareCalculator implements FareCalculator {

    private static final double BASE_FARE = 800;

    @Override
    public double calculateFare(Passenger passenger) {
        return 0;
    }

    private double applyPassengerDiscount(double fare, Passenger passenger) {
        if (passenger.getType() == PassengerType.SENEIOR_CITIZEN) {
            return fare * 0.7;
        }

        if (passenger.getType() == PassengerType.CHILD) {
            return fare * 0.6;
        }

        return fare;
    }
}

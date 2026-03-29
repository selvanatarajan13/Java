package pricing;

import domain.user.Passenger;
import domain.user.PassengerType;

public class SleeperFareCalculator implements FareCalculator {

    private static final double BASE_FARE = 500;

    @Override
    public double calculateFare(Passenger passenger) {
        return applyPassengerDiscount(BASE_FARE, passenger);
    }

    private double applyPassengerDiscount(double fare, Passenger passenger) {
        if (passenger.getType() == PassengerType.SENEIOR_CITIZEN) {
            return fare * 0.6;
        }

        if (passenger.getType() == PassengerType.CHILD) {
            return fare * 0.5;
        }

        return fare;
    }
}

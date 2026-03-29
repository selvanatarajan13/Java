package pricing;

import domain.user.Passenger;

public interface FareCalculator {

    double calculateFare(Passenger passenger);
}

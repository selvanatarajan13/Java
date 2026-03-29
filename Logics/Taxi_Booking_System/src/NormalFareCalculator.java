public class NormalFareCalculator implements FareCalculator {

    @Override
    public double calculateFare(int distance) {
        if (distance <= 5) {
            return 100;
        }

        return 100 + (distance - 5) * 10;
    }
}

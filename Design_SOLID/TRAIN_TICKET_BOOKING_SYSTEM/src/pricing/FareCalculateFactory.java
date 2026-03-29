package pricing;

public class FareCalculateFactory {

    public static FareCalculator getCalculator(String coachType) throws IllegalAccessException {

        return switch (coachType) {
            case "SLEEPER" -> new SleeperFareCalculator();
            case "AC" -> new ACFareCalculator();
            default -> throw new IllegalAccessException("Invalid coach type");
        };
    }
}

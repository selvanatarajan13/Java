package model;

public class SeatLayoutFactoryProvider {

    public static SeatLayoutFactory getFactory(BusLayoutType type) {
        return switch (type) {
            case SEATER -> new SeaterBusLayoutFactory();
            case SEMI_SLEEPER -> new SemiSleeperLayoutFactory();
            default -> new SeaterBusLayoutFactory();
        };
    }
}

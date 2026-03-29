import java.util.ArrayList;
import java.util.List;

public class TaxiFleetFactory {

    private final Factory<Taxi> taxiFactory;

    public TaxiFleetFactory(Factory<Taxi> taxiFactory) {
        this.taxiFactory = taxiFactory;
    }

    public List<Taxi> createFleet(int numberOfTaxis) {
        List<Taxi> fleet = new ArrayList<>();
        for (int i = 0; i < numberOfTaxis; i++) {
            fleet.add(taxiFactory.create());
        }
        return fleet;
    }
}

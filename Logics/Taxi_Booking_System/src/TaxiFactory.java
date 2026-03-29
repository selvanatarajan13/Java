import java.util.concurrent.atomic.AtomicInteger;

public class TaxiFactory implements Factory<Taxi> {

    private final AtomicInteger counter = new AtomicInteger(1);

    @Override
    public Taxi create() {
        return new Taxi(counter.getAndIncrement());
    }
}

import model.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SeatLayoutFactory seatFactory = SeatLayoutFactoryProvider.getFactory(BusLayoutType.SEMI_SLEEPER);
        Map<String, Seats> seaterSeats = new LinkedHashMap<>();
        seaterSeats = seatFactory.createLayout();
    }
}
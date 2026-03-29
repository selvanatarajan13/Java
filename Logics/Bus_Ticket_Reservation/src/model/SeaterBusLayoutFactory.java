package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class SeaterBusLayoutFactory implements SeatLayoutFactory {


    @Override
    public Map<String, Seats> createLayout() {

        Map<String, Seats> seatsMap = new LinkedHashMap<>();

        char[] sides = {'L', 'R'};
        char[] rows = {'A', 'B'};

        for (char side: sides) {
            for (char row: rows) {
                for (int i=1; i<=10; i++) {
                    String seatId = "" + side + row + i;
                    seatsMap.put(seatId, new Seats(seatId, SeatType.SEATER, Deck.NONE));
                }
            }
        }

        return seatsMap;
    }
}

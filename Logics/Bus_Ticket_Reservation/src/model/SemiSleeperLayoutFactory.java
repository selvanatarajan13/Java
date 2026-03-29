package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class SemiSleeperLayoutFactory implements SeatLayoutFactory {

    @Override
    public Map<String, Seats> createLayout() {

        Map<String, Seats> seatMap = new LinkedHashMap<>();
        char[] sides = {'L', 'R'};

        for (char side : sides) {
            for (int num = 1; num <= 10; num++) {
                String seatId = "" + side + "S" + num;  // LS1, RS1...
                seatMap.put(seatId, new Seats(seatId, SeatType.SEMI_SLEEPER, Deck.NONE));
            }
        }
        return seatMap;
    }
}

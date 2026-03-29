package model;

import java.util.Map;

public interface SeatLayoutFactory {
    Map<String, Seats> createLayout();
}

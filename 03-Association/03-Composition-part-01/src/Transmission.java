import java.awt.*;

public class Transmission {

    private int gears;
    private String type;

    public Transmission(int gears, String type) {
        this.gears = gears;
        this.type = type;
    }

    public void shiftGear(int gear) {
        System.out.println("Shifted to gear " + gear);
    }
}

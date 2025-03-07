import java.util.Arrays;

public class SeatAllocation {

    static int totNoSeat = 8;
    static int totNoComp = 5;
    static int[] compartment = new int[totNoComp];

    public void viewSeat() {
        for (int i=0; i<totNoComp; i++) {
            compartment[i] = totNoSeat;
        }

        System.out.println("Status of seat : " + Arrays.toString(compartment));
    }
}

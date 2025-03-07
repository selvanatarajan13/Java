public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");



        int ch=3;
        switch (ch) {
            case 1:
                System.out.println("Ticket Book");
                break;
            case 2:
                System.out.println("Cancel Ticket");
                break;
            case 3:
                System.out.println("Check Ticket Status");
                SeatAllocation seat = new SeatAllocation();
                seat.viewSeat();
                break;
            case 4:
                System.out.println("Route");
                break;
            default:
                System.out.println("");
        }
    }
}
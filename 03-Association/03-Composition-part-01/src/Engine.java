public class Engine {
    private int hoursePower;
    private int cylindrical;

    public Engine(int hoursePower, int cylindrical) {
        this.hoursePower = hoursePower;
        this.cylindrical = cylindrical;
    }

    public void start() {
        System.out.println("Engine start..");
    }

    public void stop() {
        System.out.println("Engine stop..");
    }
}

public class Car {

    static Car s = null;
    private Car() {}

    public static Car getCarInstance() {
        if (s == null) {
            s = new Car();
        }
        return s;
    }
}

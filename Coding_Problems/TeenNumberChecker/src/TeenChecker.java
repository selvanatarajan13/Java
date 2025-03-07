public class TeenChecker {
    public Number number;

    public void teenChecker() {
        number = new NumberImpl();
        Boolean result = number.hasTeen(9,19,99);
        System.out.println(result);
    }
}

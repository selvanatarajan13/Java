public class Methods {
    public static void main(String[] args) {
        int result = add();
        System.out.println(result);

        hello();
    }

    public static int add() {
        int a = 10;
        int b = 20;
        int c = a + b;

        return c;
    }

    public static void hello() {
        System.out.println("Hello Java, This is Mahendran..");
    }
}

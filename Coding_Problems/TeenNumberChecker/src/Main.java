public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        TeenChecker teenChecker = new TeenChecker();
        EqualSumChecker equalSumChecker = new EqualSumChecker();

        teenChecker.teenChecker();
        equalSumChecker.equalSumCheck();

        double i1 = 3.156, i2 = 3.156;
        int i3 = 0,i4 = 0;

        i3 = (int) (i1 * 1000);
        i4 = (int) (i2 * 1000);
        if (i3==i4) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        int d = 5;
        float r = (float) d/2;
        System.out.println(r);
    }
}
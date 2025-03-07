import java.util.Arrays;

public class PrintPrimeNumbers {
    public static void main(String[] args) {
        System.out.println("Print prime number series in given number");

        printNPrimeNo(100);
    }

    public static void printNPrimeNo(int n) {
        for (int i=2; i<=n; i++) {
            int flag = 0;
            for (int j=2; j<i; j++) {
                if (i%j == 0) {
                    flag = 1;
                }
            }

            if (flag == 0) {
                System.out.println(i);
            }
        }
    }
}

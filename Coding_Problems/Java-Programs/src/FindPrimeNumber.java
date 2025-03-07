public class FindPrimeNumber {
    public static void main(String[] args) {
        System.out.println("Find the given number is prime or not");
        checkPrime(177);
    }

    private static void checkPrime(int n) {
        int i, m, flag = 0;
        m = n / 2;
        if (n==0 || n==1) {
            System.out.println(n + " is not prime number");
        } else {
            for (i=2; i<=m; i++) {
                if (n%i==0) {
                    System.out.println(n + " is not prime number");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(n + " is prime number");
            }
        }
    }
}

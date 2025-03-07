public class FindArmstrongNumber {

    public static void main(String[] args) {
        System.out.println("Find the armstrong number");

        armstrongNumber(153);
    }

    private static void armstrongNumber(int i) {
        int sum = 0, n = i, d;
        while(n!=0) {
            d = n%10;
            sum = sum + (d*d*d);
            n = n/10;
        }

        if (sum == i) {
            System.out.println("Given number is an Armstrong");
        } else {
            System.out.println("Given number is not an Armstrong");
        }
    }
}

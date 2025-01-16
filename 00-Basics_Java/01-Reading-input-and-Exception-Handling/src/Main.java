import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // System.out.println(getInputFromConsole());

        // Instantiating scanner
        // getInputFromScanner();

        calculateAge();
    }

    public static void calculateAge() {
        int currentYear = 2024;

        System.out.println(
                currentYear - Integer.parseInt(getInputFromScanner())
        );

    }

    public static String getInputFromScanner() {

        /*
        For reading input from the console or terminal, we instantiate a scanner object using
        new, followed by the Scanner class name, and passing system.in, as an argument in the
        parenthesis.
        */

        Scanner sc = new Scanner(System.in);

        System.out.print("Hi, what's your name? ");
        String name = sc.nextLine();

        System.out.print("Enter your birth year : ");

        String birthYear = sc.nextLine();

        System.out.println("Hi, " + name);

        try {
            if (validateYear(birthYear)) {
                return birthYear;
            }
        } catch (NumberFormatException badUserData) {
            System.out.println("Sorry characters is not allowed!!Try again..");
        }



        return "0000";
    }

    private static boolean validateYear(String birthYear) {
        if (Integer.parseInt(birthYear) < 2024) {
            return true;
        }
        return false;
    }

    public static String getInputFromConsole() {
        String name = System.console().readLine("Hi, what's your name? ");
        System.out.println("Hi, " + name);

        return "";
    }
}
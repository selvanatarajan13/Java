import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse("2026/01/13", formatter);
        dateCalculateBetween(date);
    }

    public static void dateCalculateBetween(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Date: " + date);
        System.out.println("Current Date: " + currentDate);
    }
}
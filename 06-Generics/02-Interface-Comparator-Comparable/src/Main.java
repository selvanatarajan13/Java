import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Integer[] numbers = {5,0,2,10,6,15};
        Integer predict = 5;

        for (Integer i: numbers) {
            int val = predict.compareTo(i);
            System.out.printf(
                    "%d %s %d: CompareTo=%d%n", predict,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val
            );
        }

        String[] fruits = {"Kivi", "Orange", "Apple", "dragon fruit", "banana", "Mango", "strawberry"};
        Arrays.sort(fruits);
        System.out.println(Arrays.toString(fruits));

        System.out.println("P:" + (int) 'P');
        System.out.println((char) 65);

        int value = "Kivi".compareTo(fruits[0]);
        System.out.println(value);

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"), new Student("Anne")};

        // here, I would like sort the student array, but I didn't by the following statement.
        // If I hit run, then I have got the ClassCastException.
        // If I want sort the array the student class, I'm going to implement or extend the comparable interface in our student class.

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        System.out.println("Result: " + tim.compareTo(new Student("TIM")));

        // But what if we want to sort by GPA to figure out who our best students are?
        // To find that write code, But now we don't touch on compareTo() method on a StudentClass.
        // Instead of we write another class that implement Comparator and write our own sorting program.

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));

    }
}
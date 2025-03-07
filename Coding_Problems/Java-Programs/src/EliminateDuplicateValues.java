import java.util.HashSet;
import java.util.Iterator;

public class EliminateDuplicateValues {

    public static void main(String[] args) {
        System.out.println("Eliminates the dupilcates values from the array");

        int[] numbers = {10,20,10,15,25,20,30,45,30,25};

        HashSet<Integer> newNumberArray = new HashSet<>();

        for (int n : numbers) {
            newNumberArray.add(n);
        }

        System.out.println("After eliminating the duplicates values are : ");
        // newNumberArray.forEach(System.out::println);

        Iterator<Integer> numberList = newNumberArray.iterator();
        while (numberList.hasNext()) {
            System.out.print(numberList.next() next+ " ");
        }
    }
}

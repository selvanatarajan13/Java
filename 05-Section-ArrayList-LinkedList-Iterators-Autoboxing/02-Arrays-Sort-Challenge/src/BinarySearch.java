import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    // create new array using random value
    public int[] createNewArray(int[] array) {
        Random randomValue = new Random();
        for (int i=0; i<array.length; i++) {
            array[i] = randomValue.nextInt(300);
        }

        return array;
    }

    // display the array
    public void display(int[] array) {
        System.out.println("Array : ");
        System.out.println(Arrays.toString(array));
    }

    // Sort the array
    public int[] sortArray(int[] array, int[] reverseSort) {
        int temp;
        boolean flag = true;

        reverseSort = Arrays.copyOf(array, array.length);

        while (flag) {
            flag = false;
            for (int i=0; i< reverseSort.length-1; i++) {
                if (reverseSort[i] < reverseSort[i+1]) {
                    temp = reverseSort[i];
                    reverseSort[i] = reverseSort[i+1];
                    reverseSort[i+1] = temp;
                    flag = true;
                }
            }
        }

        return reverseSort;

    }
}

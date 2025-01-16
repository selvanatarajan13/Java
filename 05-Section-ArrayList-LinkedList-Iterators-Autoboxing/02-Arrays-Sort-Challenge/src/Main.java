import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java");

        int size = 10;
        int[] array = new int[size];
        BinarySearch binarySearch = new BinarySearch();

        // create new array
        binarySearch.createNewArray(array);

        // display the array
        binarySearch.display(array);


        // sort the array on reverse - perform reverse sorting
        //int[] reverseSort = new int[size];
        //binarySearch.sortArray(array, reverseSort);
        //System.out.println(Arrays.toString(reverseSort));

    }
}
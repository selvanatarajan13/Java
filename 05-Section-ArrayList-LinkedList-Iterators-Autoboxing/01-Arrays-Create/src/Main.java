import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // declare the array
        int[] arr = new int[10];

        Main main = new Main();

        // set the values into the array
        main.insertArrayValue(arr);

        // display the array
        main.displayArr(arr);

        // sum of the array
        main.sumOfArray(arr);

        // access the particular value by index
        System.out.println("\nNumber : " + arr[5]);

        // if you want to change the element in array,
        arr[0] = 78;

        main.displayArr(arr);

        // sort the array
        sortArray(arr);
    }

    private static void sortArray(int[] arr) {
        Arrays.sort(arr);
        System.out.println("\n" + Arrays.toString(arr));
    }

    public void displayArr(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    public void sumOfArray(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum = sum + element;
        }
        System.out.println("\nSum of the Array : " + sum);
    }

    public void insertArrayValue(int[] array) {
        int sum = 0;
        for (int i=0; i<array.length; i++) {
            sum =  sum + i;
            array[i] = sum;
        }
    }
}
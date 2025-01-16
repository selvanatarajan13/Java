import java.util.Arrays;

public class ArrayOperation {


    public int find(int val, Integer[] array) {

        for (int i=0; i<array.length; i++) {
            if (val == array[i]) {
                return i;
            }
        }

        return -1;
    }

    public int delete(int val, Integer[] array) {
        int position = find(val, array);

        if (position != -1) {
            for (int j=position; j<array.length-1; j++) {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = 0;
            }
        } else {
            System.out.println("\nElement not found");
        }
        return position;
    }

    public void add(int value, Integer[] array) {
        int position = find(0, array);
        if (position == -1) {
            System.out.println("\nArray elements full");
        } else {
            array[position] = value;
            System.out.println("\nAfter insert the new element : " + value);
            System.out.println(Arrays.toString(array));
        }
    }

    public void sortArray(Integer[] array) {

        Arrays.sort(array);
        System.out.println("\nAfter sorting array");
        System.out.println(Arrays.toString(array));
    }

    public void sumOfTheArray(Integer[] array) {

        int sum = 0;
        for (int element : array) {
            sum = sum + element;
        }

        System.out.println("\nSum of the array is : " + sum);
    }

    public void reverseArray(Integer[] array) {
        for (int i=array.length; i<array.length-1; i++) {

        }
    }
}

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // create array
        Integer[] array = {55,12,35,79,14,66,22};

        // display the elements
        System.out.println("Array : ");
        System.out.println(Arrays.toString(array));

        // find array element
        ArrayOperation Array = new ArrayOperation();
        int position = Array.find(35, array);
        if (position == -1){
            System.out.println("Element doesn't exist");
        } else {
            System.out.println("Element found and position of the element is " + position);
        }

        // delete the element
        int val = 12;
        int flag = Array.delete(val, array);
        Array.delete(55,array);
        Array.delete(35,array);
        if (flag != -1) {
            System.out.println("\nafter deleting the element : " + val);
            System.out.println(Arrays.toString(array));
        }

        // add element
        int value = 44;
        Array.add(value, array);
        Array.add(35, array);
        Array.add(96, array);

        // sort the array
        Array.sortArray(array);

        // sum of the array
        Array.sumOfTheArray(array);

        // reverse the array
        Array.reverseArray(array);

    }
}
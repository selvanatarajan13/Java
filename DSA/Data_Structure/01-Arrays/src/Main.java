import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int size = 5;

        int[] array = new int[size];
        array[0] = 15;
        array[1] = 20;
        array[2] = 25;
        array[3] = 30;

        //updateElement(3, 70, array);
        //insertElement(4, 44, array);
        //displayElements(array);
        //deleteElement(20, array);
        //displayElements(array);
        
    }

    private static void deleteElement(int value, int[] array) {
        for (int i=0; i<array.length-1; i++) {
            if (array[i] == value) {
                for (int j=i; j<array.length-1; j++) {

                    array[j++] = array[j];
                }
                System.out.println("\nSuccessfully deleted the element " + value);
                break;
            }
        }
    }

    private static void insertElement(int index, int value, int[] array) {

        if (index < array.length) {
            array[index] = value;
        } else {
            System.out.println("Index out of bounce.. It's range 1 to  5 elements only..");
        }
    }

    private static void updateElement(int index, int value, int[] array) {

        try {
            array[index] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print(e);
        }
    }

    private static void displayElements(int[] array) {
        System.out.print("[ ");
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.print("]");
    }
}
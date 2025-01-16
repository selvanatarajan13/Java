/*
    This program is the dynamic array concept.
    Array are linear data structures which means that the similar type of elements will be
    inserted as in a continuous manner. In array, we are faced the common issue that is size need
    to be specified at the time 0f declaration. Once you declare the array at the specific size, then
    you only insert the element based on the declaration size. This issue is overcome by using
    dynamic array. In dynamic array, we just create an array whenever the array is full then the array
    is resized.

*/

public class Arrays {
    // define fields
    private int array[];
    private int count; // here, count is declare explicitly

    public void Array(int size) {
        array = new int[size];
    }

    public void insert(int value) {
        if (array.length == count) {
            int[] newArray = new int[2 * count];

            for (int i=0; i<count; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }
        array[count++] = value;
    }

    public int find(int val) {
        for (int i=0; i<array.length; i++) {
            if (array[i] == val) {
                System.out.println(array[i]);
                System.out.println("Position of the array : " + i);
                return i;
            }
        }

        return -1;
    }

    public void delete(int val) {
        int pos = find(val);

        for (int i=pos; i<array.length-1; i++) {
            int temp = array[i];
            array[i] = array[i+1];
            array[i+1] = 0;
        }

        System.out.println("Deleted successfully..");
    }

    public void display() {
        System.out.println(java.util.Arrays.toString(array));
    }
}

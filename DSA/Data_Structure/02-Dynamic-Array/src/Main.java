public class Main {
    public static void main(String[] args) {

        /*
        * In java and C++, the limitation of an array is fixed size.
        * while in normal array we are allocating the array size at the declaration stage.
        * Overcome this limitation, we move to dynamic array concept.
        * It grows the size of array automatically when the runtime.
        * Dynamic array is a varible list size data structure.
        *
        * Dynamic array are created in two ways:-
        *       - First, we allocate the bigger array and copy all the elements from the old array and
        *       return new array
        *       - Second, create function that creates a new array of double size, copies all the elements
        *       old array to new array and return newly created array.
        *
        * In this program, I have written the second option.
        * In Java ArrayList is the resizable implementation meanwhile in C++ named vector.
         */

        System.out.println("Dynamic Array");

        DynamicArray arr = new DynamicArray();
        arr.insert(10);
        arr.insert(15);
        arr.insert(20);
        arr.insert(25);
        arr.insert(30);
        arr.insert(35);

        arr.addElementAt(1, 13);

        arr.printArray();
    }
}
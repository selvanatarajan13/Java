/*
    This program is the dynamic array concept.
    Array are linear data structures which means that the similar type of elements will be
    inserted as in a continuous manner. In array, we are faced the common issue that is size need
    to be specified at the time 0f declaration. Once you declare the array at the specific size, then
    you only insert the element based on the declaration size. This issue is overcome by using
    dynamic array. In dynamic array, we just create an array whenever the array is full then the array
    is resized.

*/

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Arrays newArray = new Arrays();
        newArray.Array(3);

        int[] valueOfArray = {10,52,78,45,54,85,36,45,36,72,33,10};

        for (int element : valueOfArray) {
            newArray.insert(element);
        }

        newArray.display();
        newArray.find(72);
        newArray.delete(72);
        newArray.delete(10);
        newArray.display();

    }
}
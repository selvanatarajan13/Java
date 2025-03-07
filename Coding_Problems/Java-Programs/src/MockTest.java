import static java.lang.Integer.*;

public class MockTest {

    /* Given an integer array nums and an integer val, remove all occurences of
    *  val in nums in-place. The relative order of the element may be changed. The
    *  remaining value must be returned. */
    static int[] expectedArray;
    public static void main(String[] args) {
        int[] array = {0,1,2,2,3,0,4,2};
        int val = 2;


        int k = removeElement(array, val);
        System.out.println("\nRemaining element : " + k);
    }

    private static int removeElement(int[] array, int val) {
        int i=0;
        int j=0;
        while(i<array.length) {
            if (array[i] != val) {
                array[j] = array[i];
                j++;
            }
            i++;
        }

        return j;

    }
}
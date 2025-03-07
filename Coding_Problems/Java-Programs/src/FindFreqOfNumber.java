public class FindFreqOfNumber {

    private static String problem = "Find the freq of each element in a limited range of" +
            " array in less than O(n) time";

    public static void main(String[] args) {
        System.out.println(problem);
        System.out.println("\nFrequency in a sorted Array\n");

        int[] array = {10, 20, 30, 30, 30, 40,
                50, 50, 50, 50, 70};
        int length = array.length;

        findFreqOfNo(array, length);
    }

    private static void findFreqOfNo(int[] array, int n) {
        int element = array[0], i = 1, freq = 1;

        while (i<n) {
            if (array[i-1] == array[i]) {
                freq++;
                i++;
            } else {
                System.out.println(element + " times " + freq);
                element = array[i];
                i++;

                freq = 1;
            }
        }
    }
}

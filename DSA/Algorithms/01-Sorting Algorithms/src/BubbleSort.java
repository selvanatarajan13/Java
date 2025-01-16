public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("Bubble Sort");
        System.out.println("Also, Find the min and max value in the given array");

        int[] array = {70,50,80,20,70,50,30,44,20};
        int len = array.length;
        sortArray(array, len);
        findMinandMax(array, len);
    }

    private static void findMinandMax(int[] array, int n) {
        int max = array[0], min = array[0];
        for (int i=0; i<n; i++) {
            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("Min = " + min + " and Max = " + max);
    }

    private static void sortArray(int[] array, int n) {
        int temp;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int numbers : array) {
            System.out.println(numbers);
        }
    }
}

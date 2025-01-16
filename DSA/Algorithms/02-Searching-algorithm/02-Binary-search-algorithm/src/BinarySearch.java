public class BinarySearch {

    public int binarySearch(int array[], int value) {
        int low = 0, high = array.length-1, mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid]==value) {
                return mid;
            } if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

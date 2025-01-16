public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BinarySearch binarySearch = new BinarySearch();
        int[] array = {2,3,4,6,18,20,25,30,45};
        int length = array.length;
        int find = 45;
        int result = binarySearch.binarySearch(array, find);

        if (result == -1) {
            System.out.println("Element is not present in an array");
        } else {
            System.out.println("Element is present at " + " index " + result + ". value = " + find);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] nums = {5, 2, 9, 1};
        Sorting sort = new SelectionSort(nums);
        sort.sort();
    }
}
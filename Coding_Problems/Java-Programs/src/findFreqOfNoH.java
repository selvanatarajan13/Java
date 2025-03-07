import java.util.HashMap;

public class findFreqOfNoH {

    private static String problem = "Find the freq of each element in a limited range of" +
            " array in less than O(n) time";

    public static void main(String[] args) {
        System.out.println(problem);
        System.out.println("Find freq of number in range of array using HashMap");

        int[] array = {10, 20, 30, 30, 30, 40,
                50, 50, 50, 50, 70};

        int length = array.length;

        findFreqNo(array, length);
    }

    private static void findFreqNo(int[] array, int length) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 0);
            }

            map.put(array[i], map.get(array[i]) + 1);
        }

        for (int value : map.keySet()) {
            System.out.println(value + "  Occure " + map.get(value) + " times.");
        }
    }
}

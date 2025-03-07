import java.util.HashMap;
import java.util.Map;
import java.lang.String;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        String s1 = "adc";
        String s2 = "egg";

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        boolean result = mapString(c1, c2);
        boolean result2 = mapString(c1,c2);

        if (result && result2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static boolean mapString(char[] s1, char[] s2) {

        Map<Character, Character> map = new HashMap<>();

        for (int i=0; i<s1.length; i++) {
            if (map.containsKey(s1[i]) != true) {
                map.put(s1[i], s2[i]);
            } else {
                if (map.containsKey(s1[i]) != map.containsValue(s2[i])) {
                    break;
                }
            }
        }

        System.out.println(map);

        return true;
    }
}
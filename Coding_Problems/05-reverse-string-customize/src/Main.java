public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int k = 39;
        String name = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int len = name.length();
        String result = reverseTheString(k, len, name);
        System.out.println(result);
        String exe = "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi";
        if (result.equals(exe)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
    }

    private static String reverseTheString(int k, int len, String s) {
//        for (int i=0; i < s.length();) {
//
//            if (i+k < len) {
//                s = s.substring(0, i) + new String(new StringBuilder(s.substring(i, i+k)).reverse())
//                        + s.substring(i+k);
//            } else {
//                break;
//            }
//            i += 2 * k;
//        }
//        return s;

        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
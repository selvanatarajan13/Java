public class Main {
    public static void main(String[] args) {

        // String result = Main.formattedString("%s %s", "Selvanatarajan", "Mahendran");
        String testString = "Anyone can learn abc's, 123's, and regular expression";
        String[] patterns = {
                "[abc]",
                "[123]",
                "[A]"
        };
        String replaceString = "(R)";
        useRegExp(testString, patterns, replaceString);
        System.out.println("-".repeat(50));

        // using Quantifier
        String[] pattern1 = {
                "[a-zA-Z]*",
                "[0-9]{1}",
                "[A-Z]*"
        };
        useRegExp(testString, pattern1, replaceString);
        System.out.println("-".repeat(50));

        // using boundry matches
        String[] pattern2 = {
                "[a-zA-Z]*$",
                "^[a-zA-Z]{5}",
                "[aA]ny//b"
        };
        useRegExp(testString, pattern2, replaceString);

        String str = "123a456";
        System.out.println(str.matches(".*a.*"));
        System.out.println(str.matches("\\d"));

        System.out.println("-".repeat(50));




    }

    private static void useRegExp(String testString, String[] patterns, String replaceString) {

        for (String pattern: patterns) {
            String data = testString.replaceFirst(pattern, replaceString);
            System.out.println("Pattern: " + pattern + " => " + data);
        }
    }

    private static String formattedString(String regExp, String... args) {

        int i = 0;
        while (regExp.matches("%s")) {
            regExp = regExp.replaceFirst("%s", args[i++]);
        }
        return regExp;
    }
}
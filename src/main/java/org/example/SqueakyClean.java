package org.example;

public class SqueakyClean {

    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();

        boolean convertKebab = false;
        for (int i = 0; i < identifier.length(); i++) {
            char ch = identifier.charAt(i);
            if (ch == ' ') {
                result.append("_");
            } else if (Character.isISOControl(ch)) {
                result.append("CTRL");
            } else if (ch == '-') {
                convertKebab = true;
            } else if (Character.isLetter(ch) && (ch < 'α' || ch > 'ω')) {
                if (convertKebab) {
                    result.append(Character.toString(ch).toUpperCase());
                    convertKebab = false;
                } else {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        String text = "a1\uD83D\uDE002\uD83D\uDE003\uD83D\uDE00b";
        System.out.println(clean(text));
        System.out.println(clean("à-ḃç"));
        System.out.println(clean("a-1C"));
        System.out.println(clean("my\0Id"));
        System.out.println(clean("MyΟβιεγτFinder"));
    }
}

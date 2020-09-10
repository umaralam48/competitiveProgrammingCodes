public class Goat {
    public static void main(String[] args) {
        String s = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(s));
    }

    public static String toGoatLatin(String S) {
        String words[] = S.split(" ");
        StringBuilder s = new StringBuilder();
        StringBuilder a = new StringBuilder("a");
        for (int i = 0; i < words.length; i++) {
            words[i] = convert(words[i], a);
            s.append(words[i]);
            s.append(" ");
            a.append('a');
        }
        return s.substring(0, s.length() - 1);
    }

    private static String convert(String s, StringBuilder a) {
        char c = Character.toUpperCase(s.charAt(0));
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            s = s + "ma";
        } else {
            s = s.substring(1) + s.charAt(0) + "ma";
        }

        return s + a;
    }
}
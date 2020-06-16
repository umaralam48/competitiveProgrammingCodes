public class CountnSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(9));
    }

    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            System.out.println(s);
            s = cnsay(s);

        }
        return s;
    }

    private static String cnsay(String s) {
        int i = 0, l = s.length();
        String str = "";
        while (i < l) {
            char c = s.charAt(i);
            int count = 0;
            while (i < l && s.charAt(i) == c) {
                count++;
                i++;
            }
            str += String.valueOf(count) + c;
        }
        return str;
    }
}
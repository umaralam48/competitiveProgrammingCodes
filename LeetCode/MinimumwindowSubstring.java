import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class MinimumwindowSubstring {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        String s = y.nextLine();
        String t = y.nextLine();
        System.out.println(minWindow(s, t));

    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length() || s.length() == 0 || t.length() == 0)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0, unique = 0;
        int[][] table = new int[2][t.length()];
        for (int i = 0; i < t.length(); i++) {
            Integer numc = map.get(t.charAt(i));
            if (numc == null) {
                unique++;
                map.put(t.charAt(i), index);
                numc = index++;
            }
            ++table[0][numc];
        }
        int left = 0, right = 0;
        int remaining = unique;
        String sub = null;

        while (right < s.length()) {
            while (remaining > 0 && right < s.length()) {
                Integer wn = map.get(s.charAt(right));
                if (wn != null && ++table[1][wn] == table[0][wn]) {
                    --remaining;
                }
                right++;
            }
            while (remaining == 0 && left < right) {
                Integer wn = map.get(s.charAt(left));
                if (wn != null && --table[1][wn] == table[0][wn] - 1) {
                    ++remaining;
                    if (sub == null || (right - left) < sub.length()) {
                        sub = s.substring(left, right);
                    }
                }
                left++;
            }

        }
        return sub != null ? sub : "";
    }
}
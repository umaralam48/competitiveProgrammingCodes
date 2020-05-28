import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LongestPalindromeSubstring {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        String nextLine = y.nextLine();
        long start = System.currentTimeMillis();
        String longestPalindrome = longestPalindrome(nextLine);
        long end = System.currentTimeMillis();
        long time = (end - start) / 1;
        System.out.println(longestPalindrome);
        System.out.println(nextLine.length());
        System.out.println(time);
    }

    private static String longestCommonSubstring(String s1, String s2) {
        int[][] l = new int[s1.length()][s2.length()];
        int z = 0;
        String s = "" + s1.charAt(0);
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0)
                        l[i][j] = 1;
                    else {

                        l[i][j] = l[i - 1][j - 1] + 1;
                        int len = l[i][j];
                        if (len > z) {
                            int sa = i - len + 1;
                            int osb = s2.length() - j - 1;
                            int oeb = s2.length() - (j - len + 1) - 1;
                            if (sa == osb && oeb == i) {
                                z = len;
                                s = s1.substring(sa, i + 1);
                            }
                            // z = len;
                            // s = s1.substring(sa, i + 1);

                        }
                    }
                } else
                    l[i][j] = 0;
            }
        }
        return s;
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty())
            return s;
        return longestCommonSubstring(s, new StringBuilder(s).reverse().toString());
    }
    /*
     * O(n^3) solution private static HashMap<String, String> map = new HashMap<>();
     * private static HashMap<String, Boolean> pmap = new HashMap<>();
     * 
     * public static String longestPalindrome(String s) { if (map.containsKey(s))
     * return map.get(s); if (isPalindrome(s)) { map.put(s, s); return s; }
     * 
     * else { String a = longestPalindrome(s.substring(1));
     * 
     * String b = longestPalindrome(s.substring(0, s.length() - 1)); if (a.length()
     * > b.length()) { map.put(s, a); return a; } else { map.put(s, b); return b; }
     * }
     * 
     * }
     */

    private static boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
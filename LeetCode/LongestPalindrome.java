public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "ababababacc";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        if (s.length() == 0)
            return 0;
        int[] a = new int[52];
        for (char c : s.toCharArray()) {
            if (c > 90) {
                a[c - 97 + 26]++;
            } else
                a[c - 65]++;
        }
        boolean flag = true;
        int count = 0;
        for (int c : a) {
            if (c % 2 != 0 && flag) {
                count++;
                count += c / 2;
                flag = false;
            } else {
                count += c / 2;
            }
        }
        return count * 2 - (!flag ? 1 : 0);
    }
}
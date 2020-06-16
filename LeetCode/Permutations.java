import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        String s = y.nextLine();

        System.out.println(permute(s, 0));
    }

    public static String permute(String s, int i) {
        int l = s.length();
        int lo = l, hi = l - 1;
        i = l - 1;
        while (i >= 0) {
            hi = l - 1;
            while (hi >= i) {
                lo = hi;
                while (lo >= i && s.charAt(lo) >= s.charAt(hi))
                    lo--;
                if (lo < i) {
                    hi--;
                } else {
                    s = s.substring(0, lo) + s.substring(hi, l) + s.substring(lo, hi);
                    System.out.println(s);
                    hi = l - 1;
                }
            }
            if (i == 0)
                return s;
            lo = l - 1;
            while (i > 0 && lo >= i && s.charAt(lo) <= s.charAt(i - 1))
                lo--;
            if (lo < i) {
                i--;
            } else {
                char c = s.charAt(lo);
                s = s.substring(0, i - 1) + c + s.substring(i, lo) + s.charAt(i - 1) + s.substring(lo + 1);
                s = s.substring(0, i) + (new StringBuffer(s.substring(i))).reverse();
            }

        }
        return s;
    }
}
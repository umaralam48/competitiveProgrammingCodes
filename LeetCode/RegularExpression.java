import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * RegularExpression
 */
public class RegularExpression {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        String nextLine = y.nextLine();

        System.out.println(isMatch(nextLine, "ab*"));
        // System.out.println();
    }

    public static boolean isMatch(String s, String p) {
        int i = 0, j = 0, l1 = s.length(), l2 = p.length();
        while (true) {
            if (j < l2 - 1 && p.charAt(j + 1) == '*') {
                if (i >= l1) {
                    return isMatch("", p.substring(j + 2));
                }
                if (p.charAt(j) == '.')
                    return isMatch(s.substring(i + 1), p.substring(j)) || isMatch(s.substring(i), p.substring(j + 2))
                            || isMatch(s.substring(i + 1), p.substring(j + 2));
                else {
                    return (s.charAt(i) == p.charAt(j) && isMatch(s.substring(i + 1), p.substring(j)))
                            || (isMatch(s.substring(i), p.substring(j + 2)));
                    // || (s.charAt(i) == p.charAt(j) && isMatch(s.substring(i + 1), p.substring(j +
                    // 2)));
                }
            } else {
                if (i < l1 && j < l2 && p.charAt(j) == '.') {
                    i++;
                    j++;
                } else {
                    if (i < l1 && j < l2 && s.charAt(i) == p.charAt(j)) {
                        i++;
                        j++;
                    } else
                        break;
                }
            }
        }
        // return true;
        return i >= l1 && j >= l2;
    }
}
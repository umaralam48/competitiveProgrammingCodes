
/**
 * Zigzagconversion
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Zigzagconversion {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        String nextLine = y.nextLine();

        System.out.println(convert(nextLine, 2));
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        // first block
        int i = 0;
        int length = s.length();
        StringBuffer sb = new StringBuffer();
        while (i < length) {
            sb.append(s.charAt(i));
            i = i + numRows + numRows - 2;
        }
        for (int j = 1; j < numRows - 1; j++) {
            int index = j;
            while (index < length) {
                sb.append(s.charAt(index));
                int secondaryindex = index + numRows - j + numRows - 2 - j;
                if (secondaryindex < length) {
                    sb.append(s.charAt(secondaryindex));
                }
                index = index + numRows + numRows - 2;

            }
        }
        // last block
        i = numRows - 1;
        while (i < length) {
            sb.append(s.charAt(i));
            i = i + numRows + numRows - 2;

        }
        return sb.toString();
    }
}
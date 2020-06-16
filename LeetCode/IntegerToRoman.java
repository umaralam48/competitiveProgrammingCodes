import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class IntegerToRoman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        System.out.println(intToRoman(n));

    }

    public static String intToRoman(int num) {
        char[] roman = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int[] nums = { 1, 5, 10, 50, 100, 500, 1000 };
        int l = 6;
        String s = "";
        while (num > 0) {
            int d = num / nums[l];
            // if (d == 0) {
            // l--;
            // continue;
            // }
            int r = num % nums[l];
            num = r;
            if (l > 0 && r / nums[l - 1] > 3) {
                num = num % nums[l - 1];
                if (d > 0) {
                    s = s + roman[l - 1] + roman[l + 1];
                    l--;
                } else
                    s = s + roman[l - 1] + roman[l];
                // l--;
            } else {
                for (int i = 0; i < d; i++) {
                    s = s + roman[l];
                }
                // l--;
            }
            l--;
        }
        return s;
    }
}
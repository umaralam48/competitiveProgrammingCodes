import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhilalandCoin {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader y = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(y.readLine());
        for (int i = 0; i < t; i++) {
            int s = Integer.parseInt(y.readLine());
            System.out.println(getdenominations(s));
        }
    }

    public static int getdenominations(int s) {
        return (int) (Math.log10(s) / Math.log10(2)) + 1;
        // int sum = 0, n = 0;
        // while (sum < s) {
        // sum = n * (n + 1) / 2;
        // sum = sum * 2 + 1;
        // n++;
        // }
        // return n;
    }
}
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class beyblade {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileInputStream("test.txt"));
        int t = y.nextInt();
        for (int i = 0; i < t; i++) {
            int n = y.nextInt();
            long us[] = new long[n];
            long them[] = new long[n];
            for (int j = 0; j < them.length; j++) {
                us[j] = y.nextLong();
            }
            for (int j = 0; j < them.length; j++) {
                them[j] = y.nextLong();
            }
            Arrays.sort(us);
            Arrays.sort(them);
            int a = 0, b = 0, wins = 0;
            while (a < us.length && b < them.length) {
                // long otherPlayer = them[b];
                if (us[a++] > them[b]) {
                    wins++;
                    b++;
                }
                // while (a < us.length && us[a++] <= otherPlayer)
                // ;
                // if (a < us.length)
                // wins++;
                // b++;
            }
            System.out.println(wins);
        }
    }
}
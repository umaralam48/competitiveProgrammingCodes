import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class countdown {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int t = y.nextInt();

        for (int i = 0; i < t; i++) {
            int n = y.nextInt();
            int k = y.nextInt();
            int[] ar = new int[n];
            for (int j = 0; j < n; j++) {
                ar[j] = y.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + kcountdown(ar, k));
        }
    }

    private static int kcountdown(int[] ar, int k) {
        int c = 1, sol = 0;
        for (int i = ar.length - 1; i >= 0; i--) {

            if (ar[i] == 1) {
                while (i > 0 && ar[i] + 1 == ar[i - 1] && c < k) {
                    i--;
                    c++;
                }
                sol += Math.max(0, c - k + 1);
                c = 1;
            }

        }
        // sol += Math.max(0, c - k + 1);
        return sol;
    }
}
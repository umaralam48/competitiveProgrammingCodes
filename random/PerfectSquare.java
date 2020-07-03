import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PerfectSquare {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader y = new BufferedReader(new FileReader("test.txt"));
        // BufferedReader y = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(y.readLine());
        for (int test = 0; test < t; test++) {

            int n = (y.read());
            int m = (y.read());
            y.readLine();
            int a[] = new int[n];
            int b[] = new int[m];
            String[] s = y.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            s = y.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for (int i = 0; i < m; i++) {
                boolean flag = false;
                for (int j = 0; j < n; j++) {
                    int product = a[i] * b[j];
                    if (product < 1)
                        continue;
                    int sqrt = (int) Math.sqrt(product);
                    if (sqrt * sqrt == product) {
                        flag = true;
                        System.out.print(b[j] + " ");
                        break;
                    }
                }
                if (!flag)
                    System.out.print(-1 + " ");
            }
        }
    }
}
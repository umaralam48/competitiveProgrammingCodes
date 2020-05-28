
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class powerpuff {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileInputStream("test.txt"));
        int n = y.nextInt();
        long pgirl[] = new long[n];
        // long lab[] = new long[n];
        // long pmax = 0;
        long mingirls = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            pgirl[i] = y.nextLong();
            // pmax = Math.max(pmax, pgirl[i]);
        }
        for (int i = 0; i < n; i++) {
            if (pgirl[i] < 1) {
                y.nextLong();
                continue;
            }
            mingirls = Math.min(mingirls, y.nextLong() / pgirl[i]);
        }
        System.out.println(mingirls);
    }
}
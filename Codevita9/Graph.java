import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        int n = y.nextInt();
        int m = y.nextInt();
        int c = 0;
        while (n != m) {

            if (n > m) {
                int fn = getFactor(n);
                c++;
                n = fn;
            } else {
                int fm = getFactor(m);
                c++;
                m = fm;
            }

        }
        System.out.println(c);
    }

    private static int getFactor(int n) {
        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0)
                return i;
        }
        return 1;
    }
}
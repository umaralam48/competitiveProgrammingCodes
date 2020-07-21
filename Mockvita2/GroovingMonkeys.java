import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GroovingMonkeys {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        int t = y.nextInt();
        for (int i = 0; i < t; i++) {
            int n = y.nextInt();
            int ar[] = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                ar[j] = y.nextInt();
            }
            System.out.println(getCycle(ar));
        }

    }

    private static int getCycle(int[] ar) {
        boolean visited[] = new boolean[ar.length];
        int lcm = 1;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i])
                continue;
            int head = i;
            visited[i] = true;
            int curr = ar[i];
            visited[curr] = true;
            int n = 0;
            while (head != curr) {
                n++;
                curr = ar[curr];
                visited[curr] = true;
            }
            lcm = getLCM(lcm, n + 1);
        }
        return lcm;
    }

    private static int getLCM(int a, int b) {
        if (b == 0)
            return a;
        int lar = Math.max(a, b);
        int small = Math.min(a, b);
        for (int i = lar;; i += lar) {
            if (i % small == 0)
                return i;
        }
    }
}
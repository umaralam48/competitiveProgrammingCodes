import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WallHeating {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        int n = y.nextInt();
        char[][] original = new char[n][n];
        char[][] leftrot = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = y.next().charAt(0);
                original[i][j] = c;
                leftrot[j][i] = c;
            }
        }
        melt(original, n);
        melt(leftrot, n);
        print(original);
        print(leftrot);
        int maxo = Math.max(calcSquare(original, n), calcSquare(leftrot, n));
        meltRight(original, n);
        meltRight(leftrot, n);
        print(original);
        print(leftrot);
        int maxr = Math.max(calcSquare(original, n), calcSquare(leftrot, n));
        int max = Math.max(maxo, maxr);
        System.out.println(max);
    }

    private static int calcSquare(char[][] a, int n) {
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int j = 0;
            while (j < n && a[i][j] == 'D')
                j++;
            int rows = i + 1;
            max = Math.max(max, Math.min(j, rows));
        }
        // System.out.println(max);
        return max;
    }

    private static void melt(char[][] a, int n) {
        for (int i = 0; i < a.length; i++) {
            int r = n - 1, c = n - 1;
            while (r >= 0) {
                if (a[r][i] == 'C') {
                    a[r][i] = 'D';
                    a[c][i] = 'C';
                    c--;
                }
                r--;
            }
        }
    }

    private static void meltRight(char[][] a, int n) {
        for (int i = 0; i < a.length; i++) {
            int r = n - 1, c = n - 1;
            while (r >= 0) {
                if (a[i][r] == 'C') {
                    a[i][r] = 'D';
                    a[i][c] = 'C';
                    c--;
                }
                r--;
            }
        }
    }

    private static void print(char[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
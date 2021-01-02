import java.util.Arrays;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        int n = 5;
        int[][] a = generateMatrix(n);
        for (int[] i : a) {
            System.out.println(Arrays.toString(i));
        }

    }

    public static int[][] generateMatrix(int n) {
        int r1 = 0, c1 = 0, r2 = n - 1, c2 = n - 1;
        int a[][] = new int[n][n];
        int c = 1;
        while (r1 <= r2 && c1 <= c2) {
            // first row
            for (int i = c1; i <= c2; i++) {
                a[r1][i] = c++;
            }
            r1++;
            // last column
            for (int i = r1; i <= r2; i++) {
                a[i][c2] = c++;
            }
            c2--;
            // last row
            for (int i = c2; i >= c1; i--) {
                a[r2][i] = c++;
            }
            r2--;
            // first column
            for (int i = r2; i >= r1; i--) {
                a[i][c1] = c++;
            }
            c1++;
        }
        return a;
    }
}

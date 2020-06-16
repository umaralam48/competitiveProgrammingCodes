import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SetMatrixZeroes {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        int n = y.nextInt();
        int m = y.nextInt();
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = y.nextInt();
            }

        }

        setZeroes(ar);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ar[i][j]);
            }
            System.out.println();
        }

    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int clo = 1;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0)
                clo = 0;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (clo == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    private static void setrc(int[][] matrix, int r, int c) {
        // set row
        setr(matrix, r);
        // set col
        setc(matrix, c);
    }

    private static void setc(int[][] matrix, int c) {
        int nr = matrix.length;
        for (int i = 0; i < nr; i++) {
            if (matrix[i][c] == 0) {
                matrix[i][c] = Integer.MIN_VALUE;
                setr(matrix, i);
            }
            matrix[i][c] = Integer.MIN_VALUE;

        }
    }

    private static void setr(int[][] matrix, int r) {
        int nc = matrix[0].length;
        for (int i = 0; i < nc; i++) {
            if (matrix[r][i] == 0) {
                matrix[r][i] = Integer.MIN_VALUE;
                setc(matrix, i);
            }

            matrix[r][i] = Integer.MIN_VALUE;
        }
    }
}
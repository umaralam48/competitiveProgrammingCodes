
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();

        display(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("Q");
            solutions.add(list);
        }
        if (n < 4) {
            return solutions;
        }
        int[] columns = new int[n];
        int[] rows = new int[n];
        int[] rd = new int[2 * n];
        int[] ld = new int[2 * n];
        int[][] board = new int[n][n];
        int queensleft = n;
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (columns[i] == 0 && rows[j] == 0 && ld[j - i + n - 1] == 0 && rd[i + j] == 0) {
                    board[j][i] = 1;
                    columns[i] = 1;
                    rows[j] = 1;
                    ld[j - i + n - 1] = 1;
                    rd[i + j] = 1;
                    queensleft--;
                    if (queensleft == 0) {
                        // print board
                        List<String> list = new ArrayList<>();
                        for (int k = 0; k < board.length; k++) {
                            String s = "";
                            for (int k2 = 0; k2 < board.length; k2++) {
                                s = s + (board[k][k2] == 0 ? '.' : 'Q');
                            }
                            list.add(s);
                        }
                        solutions.add(list);
                        board[j][i] = 0;
                        columns[i] = 0;
                        rows[j] = 0;
                        ld[j - i + n - 1] = 0;
                        rd[i + j] = 0;
                        queensleft++;
                        do {
                            i--;
                            int c = 0;
                            while (board[c++][i] != 1)
                                ;
                            board[c - 1][i] = 0;
                            rows[c - 1] = 0;
                            columns[i] = 0;
                            ld[c - 1 - i + n - 1] = 0;
                            rd[i + c - 1] = 0;
                            j = c - 1;
                            queensleft++;
                        } while (j == n - 1 && i > 0);
                        // j = c - 1;
                        // columns = new int[n];
                        // rows = new int[n];
                        // rd = new int[2 * n];
                        // ld = new int[2 * n];
                        // board = new int[n][n];

                        continue;
                    }
                    break;
                }
                while (j == n - 1 && i > 0) {
                    i--;
                    int c = 0;
                    while (c < n && board[c++][i] != 1)
                        ;

                    board[c - 1][i] = 0;
                    rows[c - 1] = 0;
                    columns[i] = 0;
                    ld[c - 1 - i + n - 1] = 0;
                    rd[i + c - 1] = 0;
                    j = c - 1;
                    queensleft++;
                    // i--;
                }
            }
        }
        System.out.println(solutions.size());
        return solutions;
    }

    private static void display(List<List<String>> list) {
        for (List<String> solution : list) {
            for (String s : solution) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
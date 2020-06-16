import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int m = y.nextInt();
        char[][] ar = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = y.next().charAt(0);
            }

        }

        System.out.println(exist(ar, "ABCB"));

    }

    static int row[] = new int[] { -1, 1 };
    static int col[] = new int[] { -1, 1 };

    public static boolean exist(char[][] board, String word) {
        if (word.equals(""))
            return true;
        int n = board.length;
        int m = board[0].length;
        char[] words = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == words[0]) {
                    char c = board[i][j];
                    board[i][j] = '#';
                    if (exists(board, words, i, j, 1))
                        return true;
                    board[i][j] = c;
                }
            }
        }
        return false;
    }

    private static boolean exists(char[][] board, char[] word, int i, int j, int index) {
        if (index >= word.length)
            return true;
        // move in column
        for (int j2 = 0; j2 < 2; j2++) {
            int nj = j + col[j2];
            if (nj < 0 || nj >= board[0].length || nj == j)
                continue;
            if (board[i][nj] == word[index]) {
                // col[(j2 + 1) % 2] = 0;
                char c = board[i][nj];
                board[i][nj] = '#';
                if (exists(board, word, i, nj, index + 1))
                    return true;
                board[i][nj] = c;
            }
        }
        // move in row
        for (int j2 = 0; j2 < 2; j2++) {
            int ni = i + row[j2];
            if (ni < 0 || ni >= board.length || ni == i)
                continue;
            if (board[ni][j] == word[index]) {
                char c = board[ni][j];
                board[ni][j] = '#';
                if (exists(board, word, ni, j, index + 1))
                    return true;
                board[ni][j] = c;
            }
        }
        return false;
    }
}
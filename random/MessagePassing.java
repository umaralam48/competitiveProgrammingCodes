import java.io.*;
import java.util.*;

class MessagePassing {

  // Complete the below function implementation
  // Print "Yes" for success and "No" for Failure
  public void messagePassTest(int n, int s, int m, int[][] matrix) {
    if (spiralOrder(matrix, s)) {
      System.out.print("Yes");
    } else {
      System.out.print("No");
    }
  }

  public boolean spiralOrder(int[][] matrix, int strength) {

    int n = matrix.length;
    if (n < 0)
      return false;
    int m = matrix[0].length;
    int[][] visited = new int[n][m];
    int[] row = { 0, 1, 0, -1 };
    int[] col = { 1, 0, -1, 0 };
    int c = 0;
    int i = 0;
    int j = 0, turns = 0;
    while (c < n * m) {
      System.out.print(strength);
      if (strength <= -1)
        return false;
      strength = Math.max(strength, matrix[i][j]);
      strength--;
      visited[i][j] = 1;
      if ((i + row[turns % 4]) >= n || (i + row[turns % 4]) < 0 || (j + col[turns % 4]) >= m || (j + col[turns % 4]) < 0
          || (visited[i + row[turns % 4]][j + col[turns % 4]] == 1)) {
        turns++;
      }
      i = i + row[turns % 4];
      j = j + col[turns % 4];
      c++;
    }
    return true;
  }

  public static void main(String args[]) {
  Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int s = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] matrix = new int[n][n];

    for (int i = 0; i < m; ++i) {
      int x, y, p;
      x = scanner.nextInt();
      y = scanner.nextInt();
      p = scanner.nextInt();
      matrix[x][y] = Math.max(p, matrix[x][y]);
    }
    scanner.close();
    new MessagePassing().messagePassTest(n, s, m, matrix);
  }
}

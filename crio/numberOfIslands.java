import java.io.*;
import java.util.*;

class NumberOfIslands {

    // Implement your solution by completing the below function
    public int numIslands(char[][] grid) {
        int arr[] = new int[grid.length * grid[0].length];
        boolean visited[] = new boolean[arr.length];
        int zeros = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    for (int k = -1; k < 2; k += 2) {
                        // vertical
                        try {
                            if (grid[i + k][j] != '1')
                                continue;
                            int r = to1d(i + k, j, n);
                            if (visited[r]) {
                                continue;
                            } else {
                                int curr = to1d(i, j, n);
                                union(arr, curr, r);
                            }
                        } catch (Exception e) {
                            // TODO: handle exception
                            continue;
                        }

                    }
                    for (int k = -1; k < 2; k += 2) {
                        // horizontal
                        try {
                            if (grid[i][j + k] != '1')
                                continue;
                            int r = to1d(i, j + k, n);
                            if (visited[r]) {
                                continue;
                            } else {
                                int curr = to1d(i, j, n);
                                union(arr, curr, r);
                            }
                        } catch (Exception e) {
                            // TODO: handle exception
                            continue;
                        }

                    }
                    visited[to1d(i, j, n)] = true;

                } else
                    zeros++;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(root(arr, i));
        }
        return set.size() - zeros;
    }

    private void union(int ar[], int i, int j) {
        int p = root(ar, i);
        int q = root(ar, j);
        ar[p] = q;
    }

    private int root(int ar[], int c) {
        while (ar[c] != c) {
            c = ar[c];
        }
        return c;
    }

    private int to1d(int r, int c, int n) {
        return r * n + c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        char[][] grid = new char[rows][columns];

        for (int i = 0; i < rows; ++i) {
            String s = scanner.next();
            for (int j = 0; j < columns; ++j) {
                grid[i][j] = s.charAt(j);
            }
        }
        scanner.close();
        int result = new NumberOfIslands().numIslands(grid);
        System.out.println(result);
    }
}
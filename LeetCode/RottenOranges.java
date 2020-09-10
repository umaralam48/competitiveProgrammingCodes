import java.util.HashSet;
import java.util.Set;

public class RottenOranges {
    public static void main(String[] args) {
        // int[][] a = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int[][] a = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        System.out.println(orangesRotting(a));
        ;
    }

    public static int orangesRotting(int[][] grid) {
        Set<String> set = new HashSet<>();
        final int empty = 0;
        final int fresh = 1;
        final int rotten = 2;
        int n = grid.length - 1;
        int m = grid[0].length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (grid[i][j] == fresh)
                    set.add(i + "" + j);
            }
        }
        boolean flag = true;
        int minutes = 0;
        while (set.size() > 0 && flag) {
            flag = false;
            minutes++;
            Set<String> rottened = new HashSet<>();
            for (String s : set) {
                int i = Integer.parseInt(s.substring(0, 1));
                int j = Integer.parseInt(s.substring(1));
                if (i > 0 && !rottened.contains((i - 1) + "" + j) && grid[i - 1][j] == rotten) {
                    grid[i][j] = rotten;
                    rottened.add(s);
                    // set.remove(s);
                    flag = true;
                } else if (j > 0 && !rottened.contains((i) + "" + (j - 1)) && grid[i][j - 1] == rotten) {
                    grid[i][j] = rotten;
                    rottened.add(s);
                    // set.remove(s);
                    flag = true;
                } else if (j < m && !rottened.contains((i) + "" + (j + 1)) && grid[i][j + 1] == rotten) {
                    grid[i][j] = rotten;
                    rottened.add(s);
                    // set.remove(s);
                    flag = true;
                } else if (i < n && !rottened.contains((i + 1) + "" + j) && grid[i + 1][j] == rotten) {
                    grid[i][j] = rotten;
                    rottened.add(s);
                    // set.remove(s);
                    flag = true;
                } else {
                    continue;
                }
            }
            for (String s : rottened) {
                set.remove(s);
            }
        }
        return set.size() == 0 ? minutes : -1;
    }
}
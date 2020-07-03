import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DungeonGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        int n = y.nextInt();
        int m = y.nextInt();
        int[][] dungeon = new int[m][n];
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < m; j++) {
                dungeon[i][j] = y.nextInt();
            }
        }
        System.out.println(calculateMinimumHP(dungeon));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] power = new int[dungeon.length][dungeon[0].length];
        power[dungeon.length - 1][dungeon[0].length - 1] = 1
                + Math.max(0, -dungeon[dungeon.length - 1][dungeon[0].length - 1]);
        for (int i = power.length - 1; i >= 0; i--) {
            for (int j = power[0].length - 1; j >= 0; j--) {
                if (i == power.length - 1 && j == power[0].length - 1)
                    continue;
                int d = Integer.MAX_VALUE;
                int r = Integer.MAX_VALUE;
                if (i < power.length - 1)
                    d = power[i + 1][j];
                if (j < power[0].length - 1)
                    r = power[i][j + 1];
                power[i][j] = Math.max(1, Math.min(d, r) - dungeon[i][j]);

            }

        }
        return power[0][0];
    }

    private static int calculateMinimumHP(int[][] dungeon, int i, int j, int p) {
        if (i == dungeon.length && j == dungeon[0].length)
            return p;
        int d = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if (i < dungeon.length)
            d = calculateMinimumHP(dungeon, i + 1, j, p - dungeon[i][j]);
        if (j < dungeon[0].length)
            r = calculateMinimumHP(dungeon, i, j + 1, p - dungeon[i][j]);
        return Math.min(d, r);
    }

}
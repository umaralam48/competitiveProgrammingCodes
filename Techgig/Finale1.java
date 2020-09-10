import java.util.Scanner;

public class Finale1 {
    public static void main(String[] args) {
        Scanner y = new Scanner(System.in);
        int f = y.nextInt();
        int[] a = new int[3];
        a[0] = y.nextInt();
        a[1] = y.nextInt();
        a[2] = y.nextInt();
        int[][][] dp = { new int[a[0] + 1][f + 1], new int[a[1] + 1][f + 1], new int[a[2] + 1][f + 1] };
        C = new int[f + 1][f + 1];
        facd = new long[f + 1];
        facd[0] = 1;
        // for (int i = 1; i < f + 1; i++) {
        // facd[i] = (facd[i - 1] * i) % 7340033;
        // }
        int ways = getWays(f, dp, a);
        System.out.println(ways);
    }

    static int[][] C;
    static long[] facd;

    public static int getWays(int f, int[][][] dp, int[] a) {
        if (f == 0)
            return 1;
        int count = 0;
        int i = 0;
        while (i < 3 && a[i] == 0)
            i++;
        if (i < 3) {
            if (dp[i][a[i]][f] > 0)
                return dp[i][a[i]][f];
            if (dp[i][a[i]][f] == -1)
                return 0;

            // handling taking 0
            a[i]--;
            if (i != 0)
                count += getWays(f, dp, a);
            int take = i == 1 ? 2 : 1;// even
            int add = i == 2 ? 1 : 2;// 3rd one
            while (take <= f) {
                int newways = ncr(f, take) * getWays(f - take, dp, a);
                count += newways;
                take += add;
            }
            a[i]++;
            if (count == 0) {
                dp[i][a[i]][f] = -1;
                return 0;
            }
            dp[i][a[i]][f] = count % 7340033;
        }
        return count;
    }

    public static int ncr(int n, int r) {

        // long numerator = 1, denominator = 1;
        // if (r > n - r) {
        // r = n - r;
        // }
        // if (fac[n][r] != 0)
        // return fac[n][r];

        // for (int i = 1; i <= r; ++i) {
        // if (facd[i] != 0) {
        // denominator = facd[i];
        // break;
        // }
        // denominator *= i;
        // denominator %= 7340033;
        // facd[i] = denominator;
        // }
        // for (long i = n - r + 1L; i <= n; ++i) {
        // numerator *= i;
        // numerator %= 7340033;
        // }
        // for (int i = 1; i < n + 1; i++) {
        // facd[i] = (facd[i - 1] * i) % 7340033;
        // }
        // fac[n][r] = (int) (facd[n] / (facd[r] * facd[n - r]));
        // return fac[n][r];
        // long C[][] = new long[n + 1][r + 1];
        int i, j;

        // Calculate value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= Math.min(i, r); j++) {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                // Calculate value using previously stored values
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        return (int) (C[n][r] % 7340033);
    }
}
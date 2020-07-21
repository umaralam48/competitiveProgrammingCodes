/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CandidateCode {
    public static void main(String args[]) throws Exception {

        // Write code here
        /// BufferedReader y=new BufferedReader(new InputStreamReader(System.in));
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        int p = y.nextInt();
        int d = y.nextInt();
        int[][] efforts = new int[d][p];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < p; j++) {
                efforts[i][j] = y.nextInt();
            }
        }
        // solution
        int used[] = new int[d];
        int[] assigned = new int[p];
        dp = new ArrayList<HashMap<String, Integer>>();

        int min = minEfforts(efforts, used, assigned, d, 0, "");
        System.out.println(min);
    }

    static ArrayList<HashMap<String, Integer>> dp;

    private static Integer minEfforts(int[][] efforts, int[] used, int[] assigned, int d, int p, String prev) {
        if (p == efforts[0].length) {
            return 0;
        }
        StringBuilder rem = new StringBuilder(prev);
        for (int i = 0; i < d; i++) {
            if (p > 0 && used[i] != 0 && assigned[p - 1] != i)
                continue;
            rem.append(i);
        }
        if (dp.size() <= p)
            dp.add(new HashMap<String, Integer>());
        Integer min = dp.get(p).get(rem.toString());
        if (min != null)
            return min;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < d; i++) {
            if (p > 0 && used[i] != 0 && assigned[p - 1] != i)
                continue;

            used[i] = used[i] + 1;
            assigned[p] = i;
            Integer next = minEfforts(efforts, used, assigned, d, p + 1, "" + i);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, efforts[i][p] + next);
            }
            used[i] = used[i] - 1;
        }
        StringBuilder s = new StringBuilder();
        if (min != Integer.MAX_VALUE)
            dp.get(p).put(rem.toString(), min);
        return min;
    }

}

/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

// import java.io.FileReader;
// import java.util.Arrays;
// import java.util.Scanner;

// public class CandidateCode {
// public static void main(String args[]) throws Exception {

// // Write code here
// /// BufferedReader y=new BufferedReader(new InputStreamReader(System.in));
// Scanner y = new Scanner(new FileReader("test.txt"));
// // Scanner y = new Scanner(System.in);
// int p = y.nextInt();
// int d = y.nextInt();
// int[][] efforts = new int[d][p];
// for (int i = 0; i < d; i++) {
// for (int j = 0; j < p; j++) {
// efforts[i][j] = y.nextInt();
// }
// }
// // solution
// int used[] = new int[d];
// int[] assigned = new int[p];
// Arrays.fill(assigned, 5);
// dp = new int[p][d];
// min = Integer.MAX_VALUE;
// minEfforts(efforts, used, assigned, d, p-1, 0);
// System.out.println(min);
// }

// static int min = Integer.MAX_VALUE;
// static int dp[][];

// private static void minEfforts(int[][] efforts, int[] used, int[] assigned,
// int d, int p, int lmin) {
// if (p < 0) {
// min = Math.min(min, lmin);
// return;
// }
// for (int i = d - 1; i >= 0; i--) {
// if (p < efforts[0].length - 1 && used[i] != 0 && assigned[p + 1] != i)
// continue;
// if ((lmin + efforts[i][p]) >= min)
// continue;
// used[i] = used[i] + 1;
// assigned[p] = i;
// // if (dp[p][i] == 0 || dp[p][i] >= lmin) {
// minEfforts(efforts, used, assigned, d, p - 1, lmin + efforts[i][p]);
// // dp[p][i] = min;
// used[i] = used[i] - 1;
// // }

// }
// }
// }

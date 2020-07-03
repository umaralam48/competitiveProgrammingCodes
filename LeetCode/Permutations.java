import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }
        System.out.println(permute(nums1));
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        boolean visited[] = new boolean[nums.length];
        List<List<Integer>> sol = new ArrayList<>();
        permute(nums, visited, sol, new ArrayList<Integer>());
        return sol;
    }
    /*
     * public static String permute(String s, int i) { int l = s.length(); int lo =
     * l, hi = l - 1; i = l - 1; while (i >= 0) { hi = l - 1; while (hi >= i) { lo =
     * hi; while (lo >= i && s.charAt(lo) >= s.charAt(hi)) lo--; if (lo < i) { hi--;
     * } else { s = s.substring(0, lo) + s.substring(hi, l) + s.substring(lo, hi);
     * System.out.println(s); hi = l - 1; } } if (i == 0) return s; lo = l - 1;
     * while (i > 0 && lo >= i && s.charAt(lo) <= s.charAt(i - 1)) lo--; if (lo < i)
     * { i--; } else { char c = s.charAt(lo); s = s.substring(0, i - 1) + c +
     * s.substring(i, lo) + s.charAt(i - 1) + s.substring(lo + 1); s =
     * s.substring(0, i) + (new StringBuffer(s.substring(i))).reverse(); }
     * 
     * } return s; }
     */

    private static void permute(int[] nums, boolean[] visited, List<List<Integer>> sol, ArrayList<Integer> arrayList) {
        if (arrayList.size() == nums.length) {
            sol.add(new ArrayList<>(arrayList));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            arrayList.add(nums[i]);
            permute(nums, visited, sol, arrayList);
            // permute(nums, visited, sol, (ArrayList<Integer>) arrayList.clone());
            arrayList.remove(arrayList.size() - 1);
            visited[i] = false;
        }
    }
}
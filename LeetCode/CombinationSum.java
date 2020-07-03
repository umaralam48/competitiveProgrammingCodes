import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }
        System.out.println(combinationSum(nums1, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        combinationSum(candidates, target, 0, sol, new ArrayList<Integer>());
        return sol;
    }

    private static void combinationSum(int[] candidates, int target, int i, List<List<Integer>> sol,
            ArrayList<Integer> arrayList) {
        if (i >= candidates.length || target < 0)
            return;
        if (target == 0) {
            sol.add(new ArrayList<>(arrayList));
            return;
        }
        for (int j = i; j <= i; j++) {
            // take element
            // arrayList.add(candidates[j]);
            // combinationSum(candidates, target - candidates[j], j + 1, sol, arrayList);
            // arrayList.remove(arrayList.size() - 1);
            // repeat element
            arrayList.add(candidates[j]);
            combinationSum(candidates, target - candidates[j], j, sol, arrayList);
            arrayList.remove(arrayList.size() - 1);
            // skip element
            combinationSum(candidates, target, j + 1, sol, arrayList);
        }
    }
}
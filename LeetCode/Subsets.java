import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();

        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {

            ar[i] = y.nextInt();

        }
        Subsets foo = new Subsets();
        List<List<Integer>> sol = foo.subsets(ar);
        System.out.println(sol);
        System.out.println(sol.size());
        System.out.println("Done");
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, list, new ArrayList<Integer>());
        return list;

    }

    private void subsets(int[] nums, int i, List<List<Integer>> sol, List<Integer> curr) {
        if (i >= nums.length)
            sol.add(new ArrayList<>(curr));
        else {
            int count = 0;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                count++;
                i++;
            }
            List<Integer> donttakethis = new ArrayList<>(curr);
            subsets(nums, i + 1, sol, donttakethis);
            List<Integer> takethis = new ArrayList<>(curr);
            takethis.add(nums[i]);
            subsets(nums, i + 1, sol, takethis);
            List<Integer> dupList = new ArrayList<>(takethis);
            for (int j = 0; j < count; j++) {
                dupList.add(nums[i]);
                subsets(nums, i + 1, sol, dupList);
            }

        }
    }
}
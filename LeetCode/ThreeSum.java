import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ContainerWithmostWater
 */
public class ThreeSum {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(threeSum(nums1, 0));
        // System.out.println();
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int a = nums[i];
                int lo = i + 1;
                int hi = nums.length - 1;
                int t = target - a;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == t) {
                        solutions.add(Arrays.asList(a, nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < t)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return solutions;
    }

}
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TargetSum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }
        count = 0;
        System.out.println(findTargetSumWays(nums1, 3));
    }

    static int count = 0;
    static int[] sum;

    public static int findTargetSumWays(int[] nums, int S) {
        count = 0;
        sum = new int[nums.length];
        int s = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            s += nums[i];
            sum[i] = s;
        }
        findTargetSumWays(nums, 0, S);
        sum = null;
        return count;
    }

    private static void findTargetSumWays(int[] nums, int i, int s) {
        if (i < nums.length) {
            // if (s > sum[i])
            // ;
            // else {
            if (sum[i] >= -s)
                findTargetSumWays(nums, i + 1, s - nums[i]);// add number
            if (sum[i] >= s)
                findTargetSumWays(nums, i + 1, s + nums[i]);// subtract number
            // }
        } else {
            if (s == 0)
                count++;
        }

    }
}
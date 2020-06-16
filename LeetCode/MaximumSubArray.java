import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MaximumSubArray {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(maxSubArray(nums1));
        // System.out.println();
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
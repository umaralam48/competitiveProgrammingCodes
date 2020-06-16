import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HouseRobber {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(rob(nums1));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] = Math.max(nums[i] + ((i + 2) < nums.length ? nums[i + 2] : 0), nums[i + 1]);
        }
        return nums[0];
    }
}
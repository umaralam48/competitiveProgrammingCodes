import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FirstandLastPositionOfElementSortedArray {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(searchRange(nums1, 4));

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] sol = { -1, -1 };
        int i = binarysearch(nums, target);
        if (i == -1)
            return sol;
        int lo = i, hi = i;
        while (lo > 0 && nums[lo] == nums[lo - 1]) {
            lo--;
        }
        while (hi < nums.length - 1 && nums[hi] == nums[hi + 1]) {
            hi++;
        }
        sol[0] = lo;
        sol[1] = hi;
        return sol;
    }

    private static int binarysearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
}
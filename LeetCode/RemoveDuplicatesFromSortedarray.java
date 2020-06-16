import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedarray {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(removeDuplicates(nums1));
        // System.out.println();
    }

    public static int removeDuplicates(int[] nums) {
        int dups = 0, j = 1, i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                i++;
                dups++;
            } else {
                nums[j] = nums[i];
                j++;
                i++;
            }
        }
        return nums.length - dups;
    }
}
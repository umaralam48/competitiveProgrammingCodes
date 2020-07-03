import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DuplicateNumber {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(findDuplicate(nums1));
    }

    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i)
                continue;
            if (nums[i] == nums[nums[i]])
                return nums[i];
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
            i--;

        }
        return 0;
    }
}
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * ContainerWithmostWater
 */
public class SortColorsJune2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        sortColors(nums1);
        System.out.print(nums1);
    }

    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            while ((nums[i] == 2 || nums[i] == 0) && left < right && i <= right) {
                while (left < right && nums[left] == 0)
                    left++;
                if (i < left)
                    i = left;
                if (nums[i] == 0 && i > left) {
                    nums[i] = nums[left];
                    nums[left++] = 0;
                }
                while (right > left && nums[right] == 2)
                    right--;
                if (nums[i] == 2 && i < right) {

                    nums[i] = nums[right];
                    nums[right--] = 2;
                }
            }
        }
    }
}
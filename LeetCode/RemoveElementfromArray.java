import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class RemoveElementfromArray {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }
        int elem = y.nextInt();
        System.out.println(removeElement(nums1, elem));
        // System.out.println();
    }

    public static int removeElement(int[] nums, int elem) {
        int dups = 0, j = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] == elem) {
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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class JumpGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(canJump(nums1));
    }

    public static boolean canJump(int[] nums) {
        int endp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            endp = Math.max(endp, i + nums[i]);
            if (endp <= i)
                return false;
            if (endp >= nums.length - 1)
                return true;
        }
        return true;
    }
}
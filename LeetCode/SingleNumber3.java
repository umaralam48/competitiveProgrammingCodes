import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SingleNumber3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }
        System.out.println(singleNumber(nums1));
    }

    public static int[] singleNumber(int[] nums) {
        // TODO
        return null;

    }
}
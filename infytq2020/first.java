import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class first {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(xorarray(nums1));
        // System.out.println();
    }

    private static int xorarray(int[] nums1) {
        // int l = nums1.length;
        // int[] b = new int[l * (l - 1) / 2];
        // int c = 0;
        int xr = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                xr = xr ^ (nums1[i] ^ nums1[j]);

            }
        }
        return xr;
    }
}
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FirstMissingPositive {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(firstMissingPositive(nums1));
    }

    public static int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; ++i)
            while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }

        for (int i = 0; i < n; ++i)
            if (A[i] != i + 1)
                return i + 1;

        return n + 1;

        // For Continuos integers
        // int max = 0, min = Integer.MAX_VALUE, sum = 0, c = 0;
        // for (int i : nums) {
        // if (i <= 0) {
        // continue;
        // }
        // if (i < min)
        // min = i;
        // if (i > max)
        // max = i;
        // sum += i;
        // c++;
        // }
        // if (min > 1)
        // return 1;
        // if (sum == (c * (c - 1) / 2))
        // return max + 1;

        // return sum - max - (c * (c - 1) / 2);
    }
}
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HIndex2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }
        System.out.println(hIndex(nums1));
    }

    public static int hIndex(int[] citations) {
        int lo = 0, hi = citations.length - 1, max = 0;
        ;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int h = citations.length - mid;
            if (citations[mid] >= h) {
                hi = mid - 1;// try increasing h
                max = Math.max(max, h);
            } else
                lo = mid + 1;

        }
        return max;
    }
}
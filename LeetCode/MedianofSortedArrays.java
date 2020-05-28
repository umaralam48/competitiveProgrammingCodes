import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MedianofSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a, b;

        if (nums1.length > nums2.length) {

            a = nums2;
            b = nums1;
        } else {
            a = nums1;
            b = nums2;
        }
        int length = a.length;
        int length2 = b.length;
        int imin = 0, imax = a.length, i = 0, j = 0;
        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = (length + length2 + 1) / 2 - i;
            if (i > 0 && a[i - 1] > b[j]) {
                imax = i - 1;
            } else if (i < length && b[j - 1] > a[i])
                imin = i + 1;
            else {
                int maxleft;
                if (i == 0)
                    maxleft = b[j - 1];
                else if (j == 0) {
                    maxleft = a[i - 1];
                } else
                    maxleft = Math.max(a[i - 1], b[j - 1]);
                if ((length + length2) % 2 == 1) {
                    return maxleft;
                } else {
                    int minright;
                    if (i == length)
                        minright = b[j];
                    else if (j == length2)
                        minright = a[i];
                    else
                        minright = Math.min(a[i], b[j]);
                    return (maxleft + minright) / 2.0;
                }
            }

        }
        return Math.max(a[i], b[j]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        int n = y.nextInt();
        int m = y.nextInt();
        int nums1[] = new int[n];
        int nums2[] = new int[m];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = y.nextInt();
        }
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
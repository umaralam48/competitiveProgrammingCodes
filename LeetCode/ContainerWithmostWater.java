import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * ContainerWithmostWater
 */
public class ContainerWithmostWater {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(maxArea(nums1));
        // System.out.println();
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        ;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }
}
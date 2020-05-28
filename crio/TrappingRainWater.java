import java.io.*;
import java.util.*;

class TrappingRainWater {

    // complete the below function implementation
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int i = 0, j = height.length - 1, lmax = height[i], rmax = height[j], sum = 0;
        while (i <= j) {
            lmax = Math.max(height[i], lmax);
            rmax = Math.max(height[j], rmax);
            if (lmax <= rmax) {
                sum += lmax - height[i];
                i++;
            } else {
                sum += rmax - height[j];
                j--;
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int height[] = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        scanner.close();
        int result = new TrappingRainWater().trap(height);
        System.out.println(result);
    }
}

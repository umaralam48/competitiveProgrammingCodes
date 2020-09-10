import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BuyAndSellStock3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(maxProfit(nums1));
    }

    public static int maxProfit(int[] prices) {
        int[] minbuy = new int[prices.length];
        minbuy[0] = prices[0];
        int[] maxsell = new int[prices.length];
        maxsell[prices.length - 1] = prices[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            minbuy[i] = Math.min(prices[i], minbuy[i - 1]);
        }
        for (int i = maxsell.length - 2; i >= 0; i--) {
            maxsell[i] = Math.max(maxsell[i + 1], prices[i]);
        }
        int max = 0;
        for (int i = 0; i < maxsell.length; i++) {
            int diff = maxsell[i] - minbuy[i];
            max = Math.max(max, diff);
        }
        return max;
    }
}
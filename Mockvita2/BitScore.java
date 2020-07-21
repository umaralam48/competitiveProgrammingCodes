import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BitScore {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(maxPairs(nums1));
    }

    private static int maxPairs(int[] nums) {
        if (nums.length < 2)
            return 0;
        int bitScores[] = new int[nums.length];
        // calculate bitscores
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int o = n % 10;
            int t = (n / 10) % 10;
            int h = (n / 100);
            int max = o > t ? (o > h ? o : h) : (t > h ? t : h);
            int min = o < t ? (o < h ? o : h) : (t < h ? t : h);
            int bitsc = max * 11 + min * 7;
            bitsc = bitsc % 100;
            bitScores[i] = bitsc;
        }
        // make pairs
        Set<String> set = new HashSet<>();
        int count[] = new int[10];
        for (int i = 0; i < bitScores.length; i++) {
            for (int j = i + 2; j < bitScores.length; j += 2) {
                int s1 = bitScores[i] / 10;
                int s2 = bitScores[j] / 10;
                if (s1 == s2 && count[s1] < 2 && !set.contains("" + bitScores[i] + "" + bitScores[j])) {
                    count[s1]++;
                    set.add("" + bitScores[i] + "" + bitScores[j]);
                }
            }
        }
        return set.size();
    }
}
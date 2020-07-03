import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Singlenumber2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }
        System.out.println(singleNumber(nums1));
    }

    public static int singleNumber(int[] nums) {

        int ones = 0, twos = 0, three = 0;
        for (int i = 0; i < nums.length; i++) {
            twos = twos | (nums[i] & ones);
            ones = ones ^ nums[i];
            three = ones & twos;
            ones = ones & (~three);
            twos = twos & (~three);
        }
        return ones;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }
        // for (Map.Entry<Integer, Integer> s : map.entrySet()) {
        // if (s.getValue() == 1)
        // return s.getKey();
        // }
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] % 3 == 0)
        // nums[i] = ++nums[i];
        // sum += nums[i];
        // }
        // for (int i = 0; i < nums.length; i++) {
        // if ((sum - nums[i]) % 3 == 0)
        // return nums[i] - 1;
        // }
        // return 0;
    }
}
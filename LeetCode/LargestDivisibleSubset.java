import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*Todo*/
public class LargestDivisibleSubset {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {

            nums1[i] = y.nextInt();

        }
        largestDivisibleSubset(nums1).stream().forEach(System.out::println);
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums)
            list.add(num);
        ArrayList<Integer> sol = new ArrayList<>();
        boolean flag[] = new boolean[nums.length];
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                int j = 0;
                int add = nums[i];
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(add + j);
                while (j + add <= nums[nums.length - 1]) {
                    j += add;
                    int index = Collections.binarySearch(list, j);
                    if (index >= 0 && index != i) {
                        curr.add(j);
                        flag[index] = true;
                        add = j;
                    }
                }
                if (curr.size() > sol.size())
                    sol = curr;
            }
        }
        return sol;

    }
}
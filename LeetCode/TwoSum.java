import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 2Sum
 */
public class TwoSum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileInputStream("test.txt"));
        ArrayList<Integer> arr = new ArrayList<>();
        while (y.hasNext()) {
            arr.add(y.nextInt());
        }
        int ar[] = arr.stream().mapToInt(Integer::intValue).toArray();

        int result[] = twoSum(ar, 10);
        System.out.println(result[0] + "\t" + result[1]);
    }

    // public static int[] twoSum(int[] nums, int target) {
    // HashMap<Integer, Integer> map = new HashMap<>();
    // Integer i1 = -1, i2 = -1;
    // for (int i = 0; i < nums.length; i++)
    // map.put(nums[i], i);
    // for (int i = 0; i < nums.length; i++) {
    // int n1 = nums[i];
    // int n2 = target - n1;
    // i1 = i;
    // i2 = map.get(n2);
    // if (i2 != null && i2 != i1) {
    // break;
    // }
    // }
    // return new int[] { i1, i2 };
    // }

    // one pass solution
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer i1 = -1, i2 = -1;

        for (int i = 0; i < nums.length; i++) {

            int n1 = nums[i];
            int n2 = target - n1;
            i1 = i;
            i2 = map.get(n2);
            if (i2 != null && i2 != i1) {
                break;
            }
            map.put(nums[i], i);
        }
        return new int[] { i1, i2 };
    }
}
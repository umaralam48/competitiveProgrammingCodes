import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class JumpGame2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(jump(nums1));
    }

    public static int jump(int[] A) {
        return jump(A, 0);
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    private static int jump(int[] a, int i) {
        if (i == a.length - 1) {
            return 0;
        }
        if (a[i] >= a.length - i - 1)
            return 1;
        if (map.containsKey(i)) {
            return map.get(i);
        }
        int min = Integer.MAX_VALUE - 1;
        for (int j = 1; j <= a[i]; j++) {
            min = Math.min(min, 1 + jump(a, i + j));
            map.put(i, min);
            if (min == 2)
                return min;
        }
        return min;
    }

}
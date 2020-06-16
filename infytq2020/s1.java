import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class s1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int a = y.nextInt();
        int b = y.nextInt();
        int r = noperations(a, b);

        System.out.println(r == Integer.MAX_VALUE ? 1 : r);
        // System.out.println();
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    private static int noperations(int a, int b) {

        if (a == b) {
            map.put(a, 0);
            return 0;
        }
        if (map.containsKey(a))
            return map.get(a);
        map.put(a, Integer.MAX_VALUE);
        if (a < b) {
            int i1;
            if (a % 2 == 0) {

                i1 = noperations(a + 1, b);
            } else {

                i1 = noperations(a - 1, b);
            }

            int i2 = noperations(a * 2, b);
            int min = Math.min(i1, i2) + 1;
            if (min <= 0) {
                return Integer.MAX_VALUE;
            }
            map.put(a, min);
            return min;
        } else {
            int i1;
            if (a % 2 != 0)
                i1 = noperations(a - 1, b) + 1;
            else {
                i1 = noperations(a / 2, b) + 1;
            }
            if (i1 <= 0) {
                return Integer.MAX_VALUE;
            }
            map.put(a, i1);
            return i1;
        }

    }
}
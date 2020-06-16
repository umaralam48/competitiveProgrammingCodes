import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int climbStairs(int n) {
        if (n < 2)
            return 1;
        if (n == 2)
            return 2;
        if (map.containsKey(n))
            return map.get(n);
        else {
            int s = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, s);
            return s;
        }
    }
}
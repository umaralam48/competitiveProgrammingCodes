public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        return numSquares(n, Integer.MAX_VALUE - 1);
    }

    private static int numSquares(int n, int min) {
        if (n == 0)
            return 0;
        if (min <= 0)
            return Integer.MAX_VALUE - 1;
        int num = n, count = 0;
        int sq = (int) Math.sqrt(num);
        for (int i = sq; i >= 1; i--) {
            sq = i;
            num = n;
            count = 0;

            num = num - sq * sq;
            count = Math.min(min, numSquares(num, min - 1) + 1);
            if (count < 3)
                return count;
            min = Math.min(min, count);
        }
        return min;
    }
}

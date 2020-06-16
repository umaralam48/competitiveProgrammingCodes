public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(-1, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        int flag = 1;
        if (n < 0) {
            n = 0 - n;
            if (n == Integer.MIN_VALUE)
                return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
            return 1.0 / myPow(x, n);
        }
        if (x < 0) {
            if (n % 2 != 0)
                flag = -1;
            x = 0 - x;
        }
        double sum = x;
        double prevsum = 1;
        int pow = 1;
        while (pow <= n && pow <= Integer.MAX_VALUE / 2) {
            prevsum = sum;
            sum = sum * sum;
            pow = pow + pow;
        }
        return flag * prevsum * myPow(x, n - (pow / 2));
    }
}
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner y = new Scanner(new FileReader("test.txt"));
        Scanner y = new Scanner(System.in);
        int lo = y.nextInt();
        int hi = y.nextInt();
        if (hi == lo) {
            // System.out.println(myPow(2, 8));
            System.out.println(1);
            return;
        }
        int p = (int) 1e9 + 7;
        int k = y.nextInt();
        fac = new int[k + 1];
        fac[0] = 1;
        for (int i = 1; i <= k; i++)
            fac[i] = fac[i - 1] * i % p;
        int vlo = lo % 2 == 0 ? lo : lo + 1;
        int vhi = hi % 2 == 0 ? hi : hi - 1;
        int even = (vhi - vlo) / 2 + 1;
        int odd = (vhi - vlo) / 2 + (vlo - lo) + (hi - vhi);
        long count = 0;
        for (int i = 0; i <= k; i += 2) {
            int takeodd = i;
            int takeeven = k - i;
            int peven = myPow(even, takeeven);
            int podd = myPow(odd, takeodd);
            int kCeven = nCrModPFermat(k, takeeven, (int) (1e9 + 7));
            kCeven = kCeven == 0 ? 1 : kCeven;
            count += (((peven * podd) % (1e9 + 7)) * (kCeven % (1e9 + 7))) % (1e9 + 7);
        }
        System.out.println(count);
    }

    static int fac[];

    /*
     * static int[][] C;
     * 
     * private static int getCombination(int n, int r) { int i, j;
     * 
     * // Calculate value of Binomial Coefficient in bottom up manner for (i = 0; i
     * <= n; i++) { for (j = 0; j <= Math.min(i, r); j++) { // Base Cases if (j == 0
     * || j == i) C[i][j] = 1;
     * 
     * // Calculate value using previously stored values else C[i][j] = (int) ((C[i
     * - 1][j - 1] + C[i - 1][j]) % (1e9 + 7)); } }
     * 
     * return (int) (C[n][r] % (1e9 + 7)); }
     */

    static int modInverse(int n, int p) {
        return myPow(n, p - 2);
    }

    // Returns nCr % p using Fermat's
    // little theorem.
    static int nCrModPFermat(int n, int r, int p) {

        // Base case
        if (r == 0)
            return 1;
        if (r == 1)
            return n % p;
        // Fill factorial array so that we
        // can find all factorial of r, n
        // and n-r

        return (((fac[n] * modInverse(fac[r], p)) % p) * (modInverse(fac[n - r], p) % p)) % p;
    }

    public static int myPow(int x, int y) {
        int p = (int) 1e9 + 7;

        // Initialize result
        int res = 1;

        // Update x if it is more than or
        // equal to p
        x = x % p;

        while (y > 0) {

            // If y is odd, multiply x
            // with result
            if (y % 2 == 1)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }

        return res;
    }
    // if (n == 0)
    // return 1;
    // int sum = (int) (x % (1e9 + 7));
    // int prevsum = 1;
    // int pow = 1;
    // while (pow <= n && pow <= Integer.MAX_VALUE / 2) {
    // prevsum = sum;
    // sum = (int) ((sum * sum) % (1e9 + 7));
    // pow = pow << 2;
    // }
    // return prevsum * myPow(x, n - (pow / 2));
}

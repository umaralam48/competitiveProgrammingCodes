
//This is The Coding Area
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LazyStudent {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader y = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(y.readLine());
        for (int i = 0; i < test; i++) {
            String s[] = y.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int t = Integer.parseInt(s[1]);
            int m = Integer.parseInt(s[2]);
            System.out.println(calculateProb(n, t, m));
        }
    }

    private static long calculateProb(int n, int t, int m) {
        if (m == 0)
            return 0;
        if (m == n)
            return 1;
        long failques = n - m;
        long totalways = getCombination(n, t);
        long failingways = getCombination(failques, t);
        long passingways = totalways - failingways;
        if (passingways == 0)
            return 0;
        long gcd = gcd(totalways, passingways);
        if (gcd != 1) {
            totalways = totalways / gcd;
            passingways = passingways / gcd;

        }
        return (passingways * mulinverse(totalways, 1000000007)) % 1000000007;
    }

    private static long mulinverse(long a, long m) {
        long m0 = m;
        long y = 0, x = 1;

        if (m == 1)
            return 0;

        while (a > 1) {
            // q is quotient
            long q = a / m;

            long t = m;

            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;

            // Update x and y
            y = x - q * y;
            x = t;
        }

        // Make x positive
        if (x < 0)
            x += m0;

        return x;
    }

    private static boolean coprimes(int totalways, int failingways) {
        if (gcd(totalways, failingways) == 1)
            return true;
        return false;
    }

    private static long gcd(long a, long b) {
        long tmp;
        while (b != 0) {
            if (a < b) {
                tmp = a;
                a = b;
                b = tmp;
            }
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    private static long getCombination(long n, long r) {
        if (r > n)
            return 0;
        if (n == r)
            return 1;
        long nfac = 1;
        for (long i = n; i > (n - r); i--) {
            nfac *= i;
            nfac = nfac % 1000000007;
        }
        long rfac = 1;
        for (long i = 2; i <= r; i++) {
            rfac *= i;
            rfac = rfac % 1000000007;
        }
        if (nfac == 0 || rfac == 0)
            return 1;
        return nfac / rfac;
    }
}
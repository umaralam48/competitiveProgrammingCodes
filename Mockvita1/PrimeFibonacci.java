import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PrimeFibonacci {
    static boolean primes[] = null;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner y = new Scanner(System.in);
        int n1 = y.nextInt();
        int n2 = y.nextInt();
        if (primes == null) {
            generatePrimes(primes);
        }
        System.out.println(primefibo(n1, n2));
    }

    private static void generatePrimes(boolean[] primes2) {
        primes = new boolean[9798];
        Arrays.fill(primes, true);
        int l = 9797;
        for (int i = 2; i < 9797; i += 2) {
            primes[i] = false;
        }
        primes[2] = true;
        for (int i = 3; i <= Math.sqrt(l); i += 2) {
            int j = i * i;
            while (j <= l) {
                primes[j] = false;
                j += i;
            }
        }
    }

    private static long primefibo(int n1, int n2) {
        List<Integer> rangeprimes = new ArrayList<>();
        for (int i = n1; i <= n2; i++) {
            if (primes[i])
                rangeprimes.add(i);
        }
        Set<Integer> set = new HashSet<>();
        // combinations
        for (int i = 0; i < rangeprimes.size(); i++) {
            for (int j = i + 1; j < rangeprimes.size(); j++) {
                int newn = rangeprimes.get(i) * (int) Math.pow(10, (int) Math.log10(rangeprimes.get(j)) + 1)
                        + rangeprimes.get(j);
                set.add(newn);
                newn = rangeprimes.get(j) * (int) Math.pow(10, (int) Math.log10(rangeprimes.get(i)) + 1)
                        + rangeprimes.get(i);
                set.add(newn);
            }
        }
        int max = 0, min = Integer.MAX_VALUE, n = 0;
        for (int num : set) {
            if (primes[num]) {
                min = Math.min(min, num);
                max = Math.max(max, num);
                n++;
            }
        }
        long a = min;
        if (n == 1)
            return a;
        long b = max;
        for (int i = 3; i <= n; i++) {
            long temp = a;
            a = b;
            b = a + temp;
        }
        return b;
    }
}
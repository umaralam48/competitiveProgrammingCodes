import java.util.Scanner;

public class TelevisonSets {
    public static void main(String[] args) {
        Scanner y = new Scanner(System.in);
        int n = y.nextInt();
        int r1 = y.nextInt();
        int r2 = y.nextInt();
        int trev = y.nextInt();

        System.out.println(numTvs(n, Math.min(r2, r1), Math.max(r2, r1), trev));
    }

    private static int numTvs(int n, int r1, int r2, int trev) {
        int lo = 0, hi = n, min = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (getrev(n, r1, r2, mid) > trev) {
                min = Math.min(min, mid);
                hi = mid - 1;
            } else
                lo = mid + 1;

        }
        return min;
    }

    private static int getrev(int n, int r1, int r2, int tvs) {
        int[] dofm = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int yearlyrev = 0;
        for (int m = 1; m <= 12; m++) {
            for (int d = 1; d <= dofm[m]; d++) {
                // per day
                int roomsreq = (int) Math.pow(6 - m, 2) + Math.abs(d - 15);
                roomsreq = Math.min(n, roomsreq);
                int rev = 0;
                if (roomsreq <= (n - tvs))
                    rev = roomsreq * r1;
                else {
                    int revntv = (n - tvs) * r1;
                    int revtv = (roomsreq - (n - tvs)) * r2;
                    rev = revntv + revtv;
                }
                yearlyrev += rev;
            }
        }

        return yearlyrev;
    }
}
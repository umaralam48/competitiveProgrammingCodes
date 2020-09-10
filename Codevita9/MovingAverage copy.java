import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MovingAverage2 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader sc = new BufferedReader(new FileReader("test.txt"));
        String[] s;
        s = sc.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int n = Integer.parseInt(sc.readLine());
        s = sc.readLine().split(" ");
        double[] a = new double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = Double.parseDouble(s[i]);
        }
        double[] xDay = new double[n - x + 1];
        double[] yDay = new double[n - y + 1];
        double sum1 = 0.0, sum2 = 0.0;
        int tail = 0;
        for (int i = 0; i < x; i++) {
            sum1 += a[i];
        }
        for (int i = 0; i < y; i++) {
            sum2 += a[i];
        }
        xDay[0] = sum1 / x;
        yDay[0] = sum2 / y;
        int j = 1;
        for (int i = x; i < n; i++) {
            sum1 += (-a[i - x] + a[i]);
            xDay[j++] = sum1 / x;
        }
        j = 1;
        for (int i = y; i < n; i++) {
            sum2 += (-a[i - y] + a[i]);
            yDay[j++] = sum2 / y;
        }
        int above = 0;
        // // calculate x-day moving average
        // for (int i = 0; i < xDay.length; i++) {
        // sum += a[i];
        // if (i >= x - 1) {
        // xDay[i] = round(sum / x);
        // sum -= a[tail];
        // tail++;
        // }
        // }

        // // calculate y-day moving average
        // sum = 0;
        // tail = 0;
        // for (int i = 0; i < yDay.length; i++) {
        // sum += a[i];
        // if (i >= y - 1) {
        // yDay[i] = round(sum / y);
        // sum -= a[tail];
        // tail++;
        // }
        // }
        int c = 0;
        if (xDay[y - x] > yDay[0])
            above = 1;

        if (xDay[y - x] < yDay[0])
            above = -1;
        for (int i = 1; i < n - y + 1; ++i) {
            if (xDay[y - x + i] < yDay[i] && above == 1) {
                c++;
                above = -1;
            } else if (xDay[y - x + i] > yDay[i] && above == -1) {
                c++;
                above = 1;
            }
            // double A = xDay[i - 1];
            // double B = xDay[i];
            // double C = yDay[i - 1];
            // double D = yDay[i];
            // int ac = Double.compare(A, C);
            // int bd = Double.compare(B, D);
            // if (ac < 0 && bd > 0)
            // c++;
            // else if (ac > 0 && bd < 0)
            // c++;
            // else if (bd == 0 && ac != 0)
            // c++;
        }
        // System.out.println(Arrays.toString(xDay));
        // System.out.println(Arrays.toString(yDay));
        System.out.println(c);
    }

    public static double round(double value) {
        return value;
        // double scale = 1e6;
        // return Math.round(value * scale) / scale;
    }
}
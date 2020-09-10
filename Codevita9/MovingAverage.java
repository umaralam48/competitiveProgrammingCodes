import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MovingAverage {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Scanner sc = new Scanner(new FileReader("test.txt"));
        // BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        // Scanner y = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new FileReader("test.txt"));
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
        double[] xDay = new double[n];
        double[] yDay = new double[n];
        double sum = 0;
        int tail = 0;

        // calculate x-day moving average
        for (int i = 0; i < xDay.length; i++) {
            sum += a[i];
            if (i >= x - 1) {
                xDay[i] = round(sum / x);
                sum -= a[tail];
                tail++;
            }
        }

        // calculate y-day moving average
        sum = 0;
        tail = 0;
        for (int i = 0; i < yDay.length; i++) {
            sum += a[i];
            if (i >= y - 1) {
                yDay[i] = round(sum / y);
                sum -= a[tail];
                tail++;

            }
        }
        int c = 0;
        for (int i = Math.max(x, y); i < yDay.length; i++) {
            double A = xDay[i - 1];
            double B = xDay[i];
            double C = yDay[i - 1];
            double D = yDay[i];
            int ac = Double.compare(A, C);
            int bd = Double.compare(B, D);
            if (ac < 0 && bd > 0)
                c++;
            else if (ac > 0 && bd < 0)
                c++;
            else if (bd == 0)
                c++;
        }
        System.out.println(Arrays.toString(xDay));
        System.out.println(Arrays.toString(yDay));
        System.out.println(c);
    }

    public static double round(double value) {
        double scale = 1e6;
        return Math.round(value * scale) / scale;
    }
}
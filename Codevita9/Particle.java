import java.io.FileNotFoundException;
import java.util.Scanner;

public class Particle {
    private static class Point {
        public int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner y = new Scanner(new FileReader("test.txt"));
        Scanner y = new Scanner(System.in);
        final int A = 0;
        final int B = 1;
        final int C = 2;
        final int D = 3;
        int n = y.nextInt();
        Point[] p = new Point[4];
        int[] s = new int[4];
        char[] d = new char[4];
        p[A] = new Point(0, 0, 0);
        p[B] = new Point(n, 0, 0);
        p[C] = new Point(n, 0, n);
        p[D] = new Point(0, 0, n);
        for (int i = 0; i < 4; i++) {
            p[i].y = y.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            s[i] = y.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            d[i] = y.next().charAt(0);
        }
        int c = 0;
        double max = 0, min = Double.MAX_VALUE;
        do {
            c = 0;
            // ADC
            double ad = getDistance(p[A], p[D]);
            double dc = getDistance(p[D], p[C]);
            double ac = getDistance(p[A], p[C]);
            double aADC = getTriangleArea(ad, dc, ac);
            // ABC
            double ab = getDistance(p[A], p[B]);
            double bc = getDistance(p[B], p[C]);
            double aABC = getTriangleArea(ac, ab, bc);
            double sum = aABC + aADC;
            double area = 4 * Math.pow(sum, 2);
            max = Math.max(area, max);
            min = Math.min(area, min);
            for (int i = 0; i < 4; i++) {
                if ((p[i].y == n && d[i] == 'U') || (p[i].y == 0 && d[i] == 'D')) {
                    c++;
                    continue;
                }
                if (d[i] == 'U') {
                    p[i].y += s[i];
                    p[i].y = Math.min(p[i].y, n);
                } else {
                    p[i].y -= s[i];
                    p[i].y = Math.max(p[i].y, 0);
                }
            }
        } while (c != 4);
        System.out.println(Math.round(max) + " " + Math.round(min));
        // System.out.println(Math.round(min));
    }

    private static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
    }

    private static double getTriangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Unlock {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        // BufferedReader sc = new BufferedReader(new FileReader("test.txt"));
        String[] s;
        s = sc.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            s = sc.readLine().split(" ");
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }
        s = sc.readLine().split(" ");
        int[] l = new int[s.length];
        List<LinkedList<Integer>> layers = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            l[i] = Integer.parseInt(s[i]);
        }
        getLayers(a, layers, n, m);
        for (int i = 0; i < l.length; i++) {
            LinkedList<Integer> list = layers.get(i);
            int v = 0;
            try {
                v = l[i] == 0 ? 0 : l[i] % list.size();
            } catch (Exception e) {
                v = 0;
            }
            // f true anticlockwise
            boolean f = i % 2 == 0;
            for (int j = 0; j < v; j++) {
                if (f) {
                    int head = list.removeFirst();
                    list.addLast(head);
                } else {
                    int tail = list.removeLast();
                    list.addFirst(tail);
                }
            }
        }
        setLayers(a, layers, n, m);
        print(a);
    }

    private static void setLayers(int[][] a, List<LinkedList<Integer>> layers, int n, int m) {
        int r1 = 0, c1 = 0, r2 = n - 1, c2 = m - 1, l = 0, c = 0;
        while (r1 < r2 && c1 < c2) {
            c = 0;
            LinkedList<Integer> list = layers.get(l);
            // first row
            for (int i = c1; i <= c2; i++, c++) {
                a[r1][i] = list.get(c);
            }
            r1++;
            // last column
            for (int i = r1; i <= r2; i++, c++) {
                a[i][c2] = list.get(c);
            }
            c2--;

            // last row
            for (int i = c2; i >= c1; i--, c++) {
                a[r2][i] = list.get(c);
            }
            r2--;

            // first column
            for (int i = r2; i >= r1; i--, c++) {
                a[i][c1] = list.get(c);
            }
            c1++;
            l++;
        }
    }

    private static void getLayers(int[][] a, List<LinkedList<Integer>> layers, int n, int m) {
        int r1 = 0, c1 = 0, r2 = n - 1, c2 = m - 1, l = 0;
        while (r1 < r2 && c1 < c2) {
            layers.add(new LinkedList<Integer>());
            LinkedList<Integer> list = layers.get(l);
            // first row
            for (int i = c1; i <= c2; i++) {
                list.add(a[r1][i]);
            }
            r1++;
            // last column
            for (int i = r1; i <= r2; i++) {
                list.add(a[i][c2]);
            }
            c2--;

            // last row
            for (int i = c2; i >= c1; i--) {
                list.add(a[r2][i]);
            }
            r2--;

            // first column
            for (int i = r2; i >= r1; i--) {
                list.add(a[i][c1]);
            }
            c1++;
            l++;
        }
    }

    private static void print(int[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        // System.out.println();
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CIDR {
    public static void main(String[] args) throws IOException {
        // BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader sc = new BufferedReader(new FileReader("test.txt"));
        String[] s;
        s = sc.readLine().split(" ");
        int r = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int cir[][][] = new int[r][2][4];
        String region[] = new String[r];
        int[][] ip = new int[n][4];
        for (int i = 0; i < r; i++) {
            s = sc.readLine().split(" ");
            cir[i][0] = getMin(s[0]);
            cir[i][1] = getMax(s[1]);
            region[i] = s[2];
        }
        for (int i = 0; i < n; i++) {
            s = sc.readLine().split("\\.");
            for (int j = 0; j < 4; j++) {
                ip[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int[] add : ip) {
            boolean f = true;
            for (int i = 0; i < r; i++) {
                int[][] cidr = cir[i];
                if (isMore(add, cidr[0]) && isLess(add, cidr[1])) {
                    System.out.println(region[i]);
                    f = false;
                    break;
                }
            }
            if (f) {
                System.out.println("None");
            }
        }

    }

    private static boolean isMore(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) {
            if (a[i] > b[i])
                return true;
            else if (a[i] == b[i])
                continue;
            else
                return false;
        }
        return true;
    }

    private static boolean isLess(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) {
            if (a[i] < b[i])
                return true;
            else if (a[i] == b[i])
                continue;
            else
                return false;
        }
        return true;
    }

    private static int[] getMax(String s) {
        String ip = s.split("/")[0];
        int cidr = (int) (32 - Integer.parseInt(s.split("/")[1]));
        int[] b = new int[4];
        String[] p = ip.split("\\.");
        for (int j = 3; j >= 0; j--) {
            b[j] = Integer.parseInt(p[j]);
            int i = 0;
            for (int k = 0; k < 8; k++) {
                i = (int) (i << 1);
                if (cidr > 0) {
                    i = (int) (i | 1);
                    cidr--;
                }
            }
            b[j] = (int) (b[j] | i);
        }
        return b;
    }

    private static int[] getMin(String s) {
        String ip = s.split("/")[0];
        int cidr = Integer.parseInt(s.split("/")[1]);
        int[] b = new int[4];
        String[] p = ip.split("\\.");
        for (int j = 0; j < 4; j++) {
            b[j] = Integer.parseInt(p[j]);
            int i = 0;
            for (int k = 0; k < 8; k++) {
                i = (int) (i << 1);
                if (cidr > 0) {
                    i = (int) (i | 1);
                    cidr--;
                }
            }
            b[j] = (int) (b[j] & i);
        }
        return b;
    }
}
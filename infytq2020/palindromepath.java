import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class palindromepath {
    static int count = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        // int m = y.nextInt();
        char nums1[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums1[i][j] = y.next().charAt(0);
            }

        }
        palindromicPath("", nums1, 0, 0, n);
        System.out.println(count);
        // System.out.println();
    }

    public static void palindromicPath(String str, char a[][], int i, int j, int n) {

        // If we have not reached bottom right corner, keep
        // exlporing
        if (j < n - 1 || i < n - 1) {
            if (i < n - 1)
                palindromicPath(str + a[i][j], a, i + 1, j, n);
            if (j < n - 1)
                palindromicPath(str + a[i][j], a, i, j + 1, n);
        }

        // If we reach bottom right corner, we check if
        // if the path used is palindrome or not.
        else {
            str = str + a[n - 1][n - 1];
            if (isPalin(str))
                count++;
        }
    }

    public static boolean isPalin(String str) {
        int len = str.length() / 2;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }
}
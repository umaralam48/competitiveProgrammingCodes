import java.io.FileReader;
import java.util.Scanner;

public class Lockdown {
    public static void main(String args[]) throws Exception {

        // Write code here
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        int n = y.nextInt();
        int[][] pairs = new int[3][3];
        pairs[0][1] = y.nextInt();
        pairs[0][2] = y.nextInt();
        pairs[1][0] = y.nextInt();
        pairs[1][2] = y.nextInt();
        pairs[2][0] = y.nextInt();
        pairs[2][1] = y.nextInt();

    }
}
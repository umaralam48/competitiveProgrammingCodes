import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class piyushandmagicpark {
    public static void main(String[] args) throws FileNotFoundException {
        // String currentDirectory = System.getProperty("user.dir");
        // System.out.println(currentDirectory);
        FileInputStream file = new FileInputStream("./test.txt");
        Scanner y = new Scanner(file);
        int n = y.nextInt();
        int m = y.nextInt();
        int k = y.nextInt();
        int s = y.nextInt();
        if (s < k) {
            System.out.println("No");
            return;
        }
        y.nextLine();
        char park[][] = new char[n][m];

        // taking input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                park[i][j] = y.next().charAt(0);
            }
            if (y.hasNextLine()) {
                y.nextLine();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s < k) {
                    System.out.println("No");
                    return;
                }

                if (park[i][j] == '.') {
                    s -= 3;
                } else if (park[i][j] == '*') {
                    s += 4;
                } else {
                    break;
                }
                if (j == (m - 1))
                    s += 1;
            }
        }
        System.out.println(s > k ? "Yes" : "No");
        if (s > k) {
            System.out.println(s);
        }
    }
}
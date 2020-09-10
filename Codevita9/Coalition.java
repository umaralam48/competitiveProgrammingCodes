import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Coalition {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        int n = y.nextInt();
        y.nextLine();
        char[] c = y.nextLine().toCharArray();
        int i = 0;
        while (i < n) {
            while (i < n && c[i] == '-')
                i++;
            if (i < n && c[i] == 'A') {
                // make left side A
                for (int j = i - 1; j >= 0; j--) {
                    if (c[j] == '-')
                        c[j] = 'A';
                    else
                        break;

                }
                while (i < n && (c[i] == 'A' || c[i] == '-'))
                    i++;
            } else {
                if (i == n)
                    break;
                // B found now finding A to its right
                while (i < n && c[i] == 'B')
                    i++;
                int j = i;
                while (j < n && c[j] == '-')
                    j++;

                // pos of - is s
                int s = i;
                i = j + 1;

                if (j < n && c[j] == 'A') {
                    j = j - 1;
                    // j is pos of A
                    while (s < j) {
                        c[s] = 'B';
                        s++;
                        c[j] = 'A';
                        j--;
                    }
                } else {
                    // B found after B
                    // j is position of B2
                    for (; s < j; s++) {
                        c[s] = 'B';
                    }
                }
            }
        }
        System.out.println(Arrays.toString(c));
        int[] count = new int[2];
        for (char ch : c) {
            if (ch == '-')
                continue;
            count[ch - 65]++;
        }
        if (count[0] > count[1])
            System.out.println('A');
        else if (count[0] < count[1])
            System.out.println('B');
        else
            System.out.println("Coalition");
    }
}
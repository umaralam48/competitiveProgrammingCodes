import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Cadbury {
    static int chocs;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        int minl = y.nextInt();
        int maxl = y.nextInt();
        int minw = y.nextInt();
        int maxw = y.nextInt();
        chocs = 0;
        for (int i = minl; i < maxl + 1; i++) {
            for (int j = minw; j < maxw + 1; j++) {
                calcChocs(i, j);
            }

        }
        System.out.println(chocs);
    }

    private static void calcChocs(int l, int w) {
        int c = 0;
        if (l == 0 || w == 0)
            return;
        else if (l < w) {
            c = w / l;
            calcChocs(l, w % l);
        }

        else {
            c = l / w;
            calcChocs(l % w, w);
        }
        chocs += c;
    }
}
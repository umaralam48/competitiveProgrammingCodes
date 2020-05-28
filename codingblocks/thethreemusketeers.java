import java.util.Scanner;

class Mars {
    public static void main(String[] args) {
        Scanner y = new Scanner(System.in);
        int t = y.nextInt();
        int anthos = 0, porthos = 0, aramis = 0;
        anthos = (int) Math.pow(2, t / 26);
        t = t % 26;
        if (t >= 10) {
            aramis = anthos;
            anthos = 0;
        } else if (t >= 2) {
            porthos = anthos;
            anthos = 0;
        }
        System.out.println(anthos + " " + porthos + " " + aramis);

    }
}

public class thethreemusketeers {

}
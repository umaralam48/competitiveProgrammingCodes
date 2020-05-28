import java.util.Scanner;

public class lcm {
    public static void main(String[] args) {
        Scanner y = new Scanner(System.in);
        int a = y.nextInt();
        int b = y.nextInt();
        System.out.println(callcm(a, b));
    }

    private static int callcm(int a, int b) {
        int lcm = Math.max(a, b);
        while (lcm % a != 0 || lcm % b != 0)
            lcm += Math.max(a, b);
        return lcm;
    }
}
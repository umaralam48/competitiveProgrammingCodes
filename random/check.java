import java.util.Scanner;

/**
 * check
 */
public class check {

    public static void main(String[] args) {
        System.out.print(args[0]);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n);
        int m = scanner.nextInt();
        System.out.println(m);
        scanner.close();
    }
}
/**
 * check
 */
public class check {

    public static void main(String[] args) {
        System.out.println(5L % 2);
        System.out.println(-7 % 4);
        // System.out.print(args[0]);
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // System.out.println(n);
        // int m = scanner.nextInt();
        // System.out.println(m);
        // scanner.close();
        String s = "/api/auth/kjkj";
        System.out.print(s.matches("/api/auth/.*"));
    }
}
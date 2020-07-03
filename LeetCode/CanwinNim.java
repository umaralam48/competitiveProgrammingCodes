public class CanwinNim {
    public static void main(String[] args) {
        System.out.println(canWinNim(5));
    }

    public static boolean canWinNim(int n) {
        return !(n % 4 == 0);
        // if (n < 4)
        // return true;
        // boolean a, b, c, d = false;
        // a = b = c = true;
        // for (int i = 4; i <= n; i++) {
        // d = !a | !b | !c;
        // c = b;
        // b = a;
        // a = d;
        // }
        // return d;
    }
}
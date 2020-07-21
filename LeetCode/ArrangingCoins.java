public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
    }

    public static int arrangeCoins(int n) {
        long N = n;
        return (-1 + (int) Math.sqrt(1 + 8 * N)) / 2;
    }
}
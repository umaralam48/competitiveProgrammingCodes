public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(3, 1));
    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor > 0) {
            count += xor & 1;
            xor = xor >> 1;
        }
        return count;
    }
}
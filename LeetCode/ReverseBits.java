public class ReverseBits {
    public static void main(String[] args) {
        int n = -1;
        // n = Integer.parseUnsignedInt("2147483649");
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.parseInt("11", 2));

        // n = Integer.sum(n, Integer.parseUnsignedInt("3"));
        // System.out.println(n);
        // System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(-2147483648));
        int rn = Integer.reverse(n);
        System.out.println(rn);
        System.out.println(Integer.toBinaryString(rn));

    }
}
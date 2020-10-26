public class NumberComplement {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(bitwiseComplement(n));
        System.out.println(getNumberOfDigits(n));

    }

    public static int getNumberOfDigits(int n) {
        int d = 0;
        do {
            d++;
            n = n / 2;
        } while (n > 0);
        return d;
    }

    public static int bitwiseComplement(Integer n) {

        return (~n) & (int) (Math.pow(2, getNumberOfDigits(n)) - 1);
    }
}

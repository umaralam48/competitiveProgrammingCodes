public class increment {
    public static void main(String[] args) {
        int n = 7;
        if ((n & 1) == 0)
            n = n | 1;
        else {
            int mask = 1;
            while ((n & mask) != 0) {
                n = n & (~mask);
                mask = mask << 1;
            }
            n = n | mask;
        }
        System.out.println(n);
    }
}
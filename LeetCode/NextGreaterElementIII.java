public class NextGreaterElementIII {
    public static void main(String[] args) {
        int n = 885576;
        System.out.println(nextGreaterElement(n));
    }

    public static int nextGreaterElement(int n) {
        if (n < 12)
            return -1;
        int[] dig = new int[10];
        dig[n % 10]++;
        int cn = n;
        int div = 100;
        while (n > (div / 10)) {
            cn = (cn / div) * div;
            int pi = (n % div) / (div / 10);
            int pib = (n % (div / 10)) / (div / 100);
            dig[pi]++;
            if (pib > pi) {
                div /= 10;
                for (int i = pi + 1; i < dig.length; i++) {
                    if (dig[i] > 0) {
                        dig[i]--;
                        cn += i * div;
                        div /= 10;
                        break;
                    }
                }

                // cn += pib * div;
                // div /= 10;
                // dig[pib]--;
                for (int i = 0; i < dig.length; i++) {
                    if (dig[i] > 0) {
                        dig[i]--;
                        cn += i * div;
                        div /= 10;
                        i--;
                    }
                }
                return cn > n ? cn : -1;
            }
            if (div > (Integer.MAX_VALUE / 10))
                return -1;
            div *= 10;
        }
        return -1;
    }
}

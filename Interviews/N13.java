class N13 {
    public static void main(String[] args) {
        int n = 8;
        int c = 0;
        for (int i = 13; i < (int) Math.pow(10, n); i++) {
            if (contains13(i))
                c++;
        }
        System.out.println(c);
        System.out.println(getNums(n));
    }

    private static int getNums(int n) {
        n--;
        int c = 0;
        int[] fac = new int[n + 1];
        fac[0] = 1;
        for (int i = 1; i < fac.length; i++) {
            fac[i] = fac[i - 1] * i;
        }
        int r = 1;
        while (r <= n) {
            int ncr = (fac[n] / (fac[r] * fac[n - r]));
            c += (Math.pow(-1, r % 2) * -1) * (ncr * Math.pow(10, n - r));
            n--;
            r++;
        }
        return c;
    }

    private static boolean contains13(int n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i + 2).equals("13"))
                return true;
        }
        return false;
    }

}
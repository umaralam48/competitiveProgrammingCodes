/**
 * @author Mohd Umar Alam
 * @version 1.0 DecodeWays
 */
public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("101"));
    }

    public static int numDecodings(String s) {
        int[] sum = new int[s.length() + 1];
        sum[sum.length - 1] = 1;
        if (Integer.parseInt("" + s.charAt(s.length() - 1)) > 0)
            sum[sum.length - 2] = 1;
        ;
        for (int i = s.length() - 2; i >= 0; i--) {
            int takeone = 0, take2 = 0;
            if (Integer.parseInt("" + s.charAt(i)) > 0)
                takeone = sum[i + 1];
            String substring = s.substring(i, i + 2);
            int doubleD = Integer.parseInt(substring);
            if (doubleD < 27 && doubleD > 9)
                take2 = sum[i + 2];
            sum[i] = take2 + takeone;
        }
        return sum[0];
    }
}

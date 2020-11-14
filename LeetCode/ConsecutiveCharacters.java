public class ConsecutiveCharacters {
    public static void main(String[] args) {
        String s = "triplepillooooow";
        System.out.println(maxPower(s));
    }

    public static int maxPower(String s) {
        char c[] = s.toCharArray();
        int max = 0;
        if (c.length == 0)
            return max;
        char prev = c[0];
        int count = 1;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == prev)
                count++;
            else {
                max = Math.max(max, count);
                count = 1;
                prev = c[i];
            }
        }
        return max;
    }
}

public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public static void main(String[] args) {
        int a[] = { 60, 60, 60 };
        System.out.println(numPairsDivisibleBy60(a));
        // System.out.println(60 % 60);
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int c = 0;
        int[] rem = new int[60];
        for (int i = 0; i < time.length; i++) {
            rem[time[i] % 60]++;
        }
        for (int i = 0; i < time.length; i++) {
            int r1 = time[i] % 60;
            if (rem[r1] == 0)
                continue;
            int r2 = (60 - r1) % 60;
            if (r1 == r2) {
                c += (rem[r1] * (rem[r1] - 1)) / 2;
            } else
                c += rem[r1] * rem[r2];
            rem[r1] = 0;
            rem[r2] = 0;

        }
        return c;
    }
}

public class BullsAndCows {
    public static void main(String[] args) {
        String secret = "1121";
        String guess = "0111";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        char[] sec = secret.toCharArray();
        char[] gues = guess.toCharArray();
        int[] map = new int[10];
        for (char c : sec) {
            map[c - '0']++;
        }
        int bulls = 0, cows = 0;
        for (int i = 0; i < gues.length; i++) {
            if (sec[i] == gues[i]) {
                bulls++;
            }
            if (map[gues[i] - '0'] > 0) {
                map[gues[i] - '0']--;
                cows++;
            }
        }
        return bulls + "A" + (cows - bulls) + "B";
    }
}

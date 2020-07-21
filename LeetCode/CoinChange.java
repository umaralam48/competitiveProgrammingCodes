public class CoinChange {
    public static void main(String[] args) {
        int[] denominations = { 186, 419, 83, 408 };

        System.out.println(coinChange(denominations, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins);
        return coinChange(coins, amount, new int[amount]);

    }

    private static int coinChange(int[] coins, int amount, int[] mem) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (mem[amount - 1] != 0)
            return mem[amount - 1];
        int min = Integer.MAX_VALUE;
        int i = coins.length;
        while (i > 0 && amount > 0) {
            i--;

            int temp = coinChange(coins, amount - coins[i], mem);
            if (temp == -1)
                continue;
            min = Math.min(min, temp + 1);

        }

        mem[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return mem[amount - 1];

    }
}
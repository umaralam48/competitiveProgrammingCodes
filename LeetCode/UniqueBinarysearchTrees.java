public class UniqueBinarysearchTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(6));
    }

    public static int numTrees(int n) {
        if (n < 2)
            return 1;
        int[] num = new int[n + 1];
        num[0] = num[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j <= i - 1; j++) {
                int k = i - j - 1;
                sum += num[j] * num[k];
            }
            num[i] = sum;
        }
        return num[n];
    }
}
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
    }

    public static int uniquePaths(int m, int n) {
        int N = m + n - 2;// total moves
        int denominator = 1;
        long solution = 1;
        for (int i = (N - n + 2); i <= N; i++) {
            solution = (solution * i) / denominator;
            denominator++;
        }
        return (int) solution;
    }
}
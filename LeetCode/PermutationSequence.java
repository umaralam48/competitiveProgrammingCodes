public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }

    public static String getPermutation(int n, int k) {
        boolean visited[] = new boolean[n + 1];
        return getPermutation(n, k, visited, "");
    }

    static int count = 0;

    private static String getPermutation(int n, int k, boolean[] visited, String permutation) {
        if (permutation.length() == n) {
            count++;
            System.out.println(permutation);
            if (count == k)
                return permutation;
        }

        // return permutation;
        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            String s = getPermutation(n, k, visited, permutation + i);
            if (s != null)
                return s;
            visited[i] = false;

        }
        return null;
    }
}
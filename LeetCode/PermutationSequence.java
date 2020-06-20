public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }

    public static String getPermutation(int n, int k) {
        boolean visited[] = new boolean[n + 1];
        return getPermutation(n, k, visited, "");
    }

    private static String getPermutation(int n, int k, boolean[] visited, String permutation) {
        if (permutation.length() == n)
            System.out.println(permutation);
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
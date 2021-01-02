public class JumpGame3 {
    public static void main(String[] args) {
        int[] a = { 3, 0, 2, 1, 2 };
        System.out.println(canReach(a, 2));

    }

    public static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return canReach(arr, visited, start);

    }

    private static boolean canReach(int[] arr, boolean[] visited, int start) {
        System.out.println(start);
        if (start < 0 || start >= arr.length)
            return false;
        if (visited[start])
            return false;
        if (arr[start] == 0)
            return true;
        visited[start] = true;
        return canReach(arr, visited, start + arr[start]) || canReach(arr, visited, start - arr[start]);
    }
}

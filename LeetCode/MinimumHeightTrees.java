import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        int n = 6;
        int[][] a = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
        System.out.println(findMinHeightTrees(n, a).toString());
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = dfs(i, visited, g);
            if (height < min) {
                ans = new ArrayList<>();
                ans.add(i);
                min = height;
            } else if (height == min) {
                ans.add(i);
            }
        }

        return ans;
    }

    private static int dfs(int src, boolean[] visited, List<List<Integer>> g) {
        visited[src] = true;
        int max = 0;
        for (Integer n : g.get(src)) {
            if (!visited[n]) {
                max = Math.max(max, 1 + dfs(n, visited, g));
            }
        }
        visited[src] = false;
        return max;
    }
}
import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] ar = { { 1 } };
        System.out.println(allPathsSourceTarget(ar));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int s = 0;
        int t = graph.length - 1;
        boolean visited[] = new boolean[t + 1];
        sol = new ArrayList<>();
        if (graph.length == 0 || graph[0].length == 0)
            return sol;
        List<Integer> path = new ArrayList<Integer>();
        path.add(s);
        dfs(graph, visited, path, s, t);
        return sol;
    }

    static List<List<Integer>> sol;

    private static void dfs(int[][] graph, boolean[] visited, List<Integer> path, int s, int t) {
        if (s == t) {
            sol.add(new ArrayList<>(path));
            return;
        }
        for (int neighbour : graph[s]) {
            if (visited[neighbour])
                continue;
            visited[neighbour] = true;
            path.add(neighbour);
            dfs(graph, visited, path, neighbour, t);
            visited[neighbour] = false;
            path.remove(path.size() - 1);
        }
    }
}
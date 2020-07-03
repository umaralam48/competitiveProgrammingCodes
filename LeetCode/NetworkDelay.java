import java.util.LinkedList;
import java.util.Queue;

public class NetworkDelay {
    public static void main(String[] args) {
        int[][] ar = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        System.out.println(networkDelayTime(ar, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        int dis[] = new int[N + 1];
        for (int i = 1; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[K] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i = 0; i < times.length; i++) {
                int u = times[i][0];
                if (u != c)
                    continue;
                int v = times[i][1];
                int w = times[i][2];
                if (dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                    if (!q.contains(v))
                        q.add(v);
                }

            }
        }
        int max = 0;
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dis[i]);
        }

        return max;
    }
}
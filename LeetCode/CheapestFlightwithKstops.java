public class CheapestFlightwithKstops {
    public static void main(String[] args) {
        System.out.println(findCheapestPrice(3, new int[][] { { 0, 1, 2 }, { 1, 2, 1 }, { 2, 0, 10 } }, 1, 2, 1));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // int[] previous = new int[n];
        int[][] distance = new int[n][n];
        for (int i = 0; i < distance.length; i++) {
            distance[i][0] = Integer.MAX_VALUE;
        }
        distance[src][0] = 0;
        // previous[src] = src;
        for (int k = 1; k <= n - 1; k++) {
            for (int i = 0; i < n; i++) {
                distance[i][k] = Integer.MAX_VALUE;
            }
            distance[src][k] = 0;

            for (int j = 0; j < flights.length; j++) {
                int u = flights[j][0];
                int v = flights[j][1];
                int w = flights[j][2];

                distance[v][k] = Math.min(distance[v][k],
                        (distance[u][k - 1] + w) < 0 ? Integer.MAX_VALUE : (distance[u][k - 1] + w));

            }
        }
        int k = (K + 1) >= (n - 1) ? (n - 1) : (K + 1);
        if (distance[dst][k] == Integer.MAX_VALUE)
            return -1;
        return distance[dst][k];
    }
}
public class GCO {
    public static void main(String[] args) {
        Integer[][] ar = { { 2, null, 2, null }, { 2, null, 2, null }, { null, null, null, null },
                { null, null, null, null } };
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (ar[x + 1][y] != null) {
                    if (ar[x + 1][y] == ar[x][y]) {
                        ar[x][y] = 2 * ar[x][y];
                        ar[x + 1][y] = null;
                    }
                    if (ar[x][y] == null) {
                        ar[x][y] = ar[x + 1][y];
                        ar[x + 1][y] = null;
                    }
                }
            }
        }
        System.out.println("End");
    }
}
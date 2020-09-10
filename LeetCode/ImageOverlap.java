public class ImageOverlap {
    public static void main(String[] args) {
        int[][] a = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
        int[][] b = { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };
        System.out.println(largestOverlap(a, b));
    }

    public static int largestOverlap(int[][] A, int[][] B) {
        int l = A.length;
        int ar = 0, ac = 0, br = 0, bc = 0, max = 0;
        // shift top i.e. row
        for (int i = 0; i < l; i++, ar++) {
            ac = 0;
            bc = 0;
            // shift left
            for (int j = 0; j < B.length; j++, ac++) {
                max = Math.max(max, getOverlap(A, B, ar, ac, 0, 0));
            }

            // shift right
            for (int j = 0; j < B.length; j++, bc++) {
                max = Math.max(max, getOverlap(A, B, ar, 0, 0, bc));
            }

        }

        ar = ac = br = bc = 0;
        // shift bottom i.e. row
        for (int i = 0; i < l; i++, br++) {
            ac = 0;
            bc = 0;
            // shift left
            for (int j = 0; j < B.length; j++, ac++) {
                max = Math.max(max, getOverlap(A, B, 0, ac, br, 0));
            }

            // shift right
            for (int j = 0; j < B.length; j++, bc++) {
                max = Math.max(max, getOverlap(A, B, 0, 0, br, bc));
            }
        }
        return max;
    }

    private static int getOverlap(int[][] a, int[][] b, int ia, int ic, int jb, int jc) {
        int overlap = 0;
        int l = a.length;
        for (; ia < l && jb < l; ia++, jb++) {
            for (int i = ic, j = jc; i < l && j < l; i++, j++) {
                if (a[ia][i] == 1 && b[jb][j] == 1)
                    overlap++;
            }
        }
        return overlap;
    }
}

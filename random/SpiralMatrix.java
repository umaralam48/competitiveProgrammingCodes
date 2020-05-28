import java.util.*;

class SpiralMatrix {
    // Implement your solution by completing the below function
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<Integer>();
        int r1 = 0, c1 = 0;
        int r2 = matrix.length - 1;
        int c2 = matrix[0].length - 1;
        while (validate(r1, r2, c1, c2)) {
            traverseRow(matrix, lst, r1, c1, c2);
            if (!validate(++r1, r2, c1, c2))
                break;
            traverseColumn(matrix, lst, c2, r1, r2);
            if (!validate(r1, r2, c1, --c2))
                break;
            traverseRow(matrix, lst, r2, c2, c1);
            if (!validate(r1, --r2, c1, c2))
                break;
            traverseColumn(matrix, lst, c1, r2, r1);
            c1++;

        }
        return lst;
    }

    private boolean validate(int r1, int r2, int c1, int c2) {
        return r1 <= r2 && c1 <= c2;
    }

    private void traverseColumn(int[][] matrix, List<Integer> lst, int column, int start, int end) {
        int step = (end - start) > 0 ? 1 : -1;

        for (int i = start; i != end; i += step) {
            lst.add(matrix[i][column]);
        }
        lst.add(matrix[end][column]);
    }

    private void traverseRow(int[][] matrix, List<Integer> lst, int row, int start, int end) {
        int step = (end - start) > 0 ? 1 : -1;
        for (int i = start; i != end; i += step) {
            lst.add(matrix[row][i]);
        }
        lst.add(matrix[row][end]);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                matrix[i][j] = scanner.nextInt();
        scanner.close();

        List<Integer> result = new SpiralMatrix().spiralOrder(matrix);
        for (int i = 0; i < result.size(); ++i)
            System.out.printf("%d ", result.get(i));
    }
}

import java.util.Arrays;

public class PrisonCellsAfterNDays {
    public static void main(String[] args) {
        int ar[] = { 1, 0, 0, 1, 0, 0, 0, 1 };
        System.out.println(Arrays.toString(prisonAfterNDays(ar, 826)));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        if (N % 14 == 0)
            N = 14;
        else if (N > 14)
            N = N % 14;

        for (int i = 1; i <= N; i++) {
            int temp = cells[0];
            cells[0] = 0;
            for (int j = 1; j < cells.length - 1; j++) {
                temp = (temp ^ cells[j + 1]) ^ 1;
                int temptemp = temp;
                temp = cells[j];
                cells[j] = temptemp;
            }
            cells[7] = 0;
            System.out.println(Arrays.toString(cells));
        }
        return cells;
    }
}
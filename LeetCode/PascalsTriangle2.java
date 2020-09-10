import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangle2 {
    public static void main(String[] args) {
        System.out.println(getRow(4));
    }

    public static List<Integer> getRow(int rowIndex) {
        // List<Integer> list = new ArrayList<>();
        // list.add(1);
        int[] a = new int[rowIndex + 1];
        a[0] = 1;
        for (int i = 0; i <= rowIndex; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i + 1; j++) {
                right = a[j];
                a[j] = left + right;
                left = right;
            }

        }
        return Arrays.stream(a).boxed().collect(Collectors.toList());
    }
}
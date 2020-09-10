import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {
    public static void main(String[] args) {
        int[] a = { 3, 2, 4, 1 };
        System.out.println(pancakeSort(a));
        System.out.println(Arrays.toString(a));
    }

    public static List<Integer> pancakeSort(int[] A) {
        int l = A.length - 1;
        int e = l;
        List<Integer> k = new ArrayList<>();
        while (e > 0) {
            e = l;
            int a = A[0];
            if (a < A[e]) {
                e--;
                while (e >= 0 && A[e] < A[e + 1]) {
                    e--;
                }
            }
            if (e < 0)
                return k;
            k.add(e);
            int end = e, start = 0;
            while (start <= end) {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start++;
                end--;
            }
        }
        return k;
    }
}
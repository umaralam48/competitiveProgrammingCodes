import java.util.Arrays;

public class ZeroesRight {
    public static void main(String[] args) {
        int[] a = { 0, 12, 0, 1, 3 };
        moveZeroes(a);
        Arrays.stream(a).forEach(System.out::println);

    }

    static void moveZeroes(int[] A) {
        int empty = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                A[empty++] = A[i];
            }
        }
        for (int i = empty; i < A.length; i++) {
            A[i] = 0;
        }
    }
}

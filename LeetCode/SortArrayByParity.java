import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] a = { 1, 3, 7, 9 };
        System.out.println(Arrays.toString(sortArrayByParity(a)));
    }

    public static int[] sortArrayByParity(int[] A) {
        int r = 0;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0) {
                int temp = A[r];
                A[r] = A[i];
                A[i] = temp;
                r++;
            }
        }
        return A;
    }
}
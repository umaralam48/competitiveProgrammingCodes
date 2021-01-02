public class SmallestRange2 {
    public static void main(String[] args) {
        int a[] = {};
        System.out.println(smallestRangeII(a, 3));
    }

    public static int smallestRangeII(int[] A, int K) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int ai = A[i];
            if (ai < min)
                min = ai;
            if (ai > max)
                max = ai;
        }
        if (K >= (max - min))
            return max - min;
        int mid = (min + max) / 2;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= mid)
                A[i] += K;
            else
                A[i] -= K;

            if (A[i] < min)
                min = A[i];
            if (A[i] > max)
                max = A[i];
            mid = (min + max) / 2;
        }
        return max - min;
    }
}

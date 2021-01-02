public class LongestMountain {
    public static void main(String[] args) {
        int a[] = { 2, 2, 2 };
        System.out.println(longestMountain(a));
    }

    public static int longestMountain(int[] A) {
        int max = 0;
        if (A.length < 3)
            return 0;
        int r = 0;
        boolean rise = false, fall = false;
        for (int i = 1; i < A.length; i++) {
            if (rise == false && fall == false && A[i - 1] < A[i]) {
                {
                    rise = true;
                    r = i - 1;
                }
            } else if (rise && A[i - 1] < A[i])
                continue;
            else if (rise && A[i] < A[i - 1]) {
                rise = false;
                fall = true;
            } else if (fall && A[i - 1] > A[i])
                continue;
            else if (fall && A[i] > A[i - 1]) {
                int dis = i - r;
                r = i - 1;
                fall = false;
                rise = true;
                if (dis >= 3)
                    max = Math.max(dis, max);
            } else {
                int dis = i - r;
                if (dis >= 3)
                    max = Math.max(dis, max);
                r = i;
                rise = false;
                fall = false;
            }
        }
        if (fall && A[A.length - 1] < A[A.length - 2]) {
            int dis = A.length - r;
            if (dis >= 3)
                max = Math.max(dis, max);
        }
        return max;
    }
}

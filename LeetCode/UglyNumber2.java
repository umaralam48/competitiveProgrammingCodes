import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumber2 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1600));
    }

    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        long num = 1;
        while (n > 0) {
            num = pq.poll();
            if (!set.contains(num * 2) && (num * 2) > 0) {
                pq.add(num * 2);
                set.add(num * 2);
            }
            if (!set.contains(num * 3) && (num * 3) > 0) {
                pq.add(num * 3);
                set.add(num * 3);
            }
            if (!set.contains(num * 5) && (num * 5) > 0) {
                pq.add(num * 5);
                set.add(num * 5);
            }
            n--;

        }
        return (int) num;

    }
}
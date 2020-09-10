import java.util.Collections;
import java.util.LinkedList;

/**
 * TaskScheduler
 */
public class TaskScheduler {

    public static void main(String[] args) {
        System.out.println((int) 'A');
        // char[] ar = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        // char[] ar = { 'A', 'A', 'A', 'B', 'B', 'B' };
        char[] ar = { 'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J',
                'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T',
                'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z' };
        System.out.println(leastInterval(ar, 2));

    }

    public static int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        int time = tasks.length;
        int freq[] = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 65]++;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                list.add(freq[i]);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        while (!list.isEmpty()) {
            int c = n;
            int s = list.size();
            if (list.size() < n + 1) {
                c = list.size() - 1;
            }
            for (int i = 0; i <= c; i++) {
                int count = list.get(i) - 1;
                list.remove(i);
                list.add(i, count);
                if (list.get(i) == 0) {
                    list.remove(i);
                    i--;
                    c--;
                }
            }
            if (!list.isEmpty() && s < n + 1)
                time += 1 + n - s;
            Collections.sort(list, Collections.reverseOrder());
        }
        return time;

    }
}
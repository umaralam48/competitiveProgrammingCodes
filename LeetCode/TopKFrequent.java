import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class TopKFrequent {
    HashMap<Integer, Integer> map;
    int unique[];

    public static void main(String[] args) {
        int ar[] = { 1, 1, 1, 2, 2, 3 };
        TopKFrequent obj = new TopKFrequent();
        System.out.println(Arrays.toString(obj.topKFrequent(ar, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        map = new HashMap<>();
        // create hashmap of frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // get unique elements into an array
        unique = new int[map.size()];
        int i = 0;
        for (int num : map.keySet()) {
            unique[i++] = num;
        }
        if (unique.length < 2)
            return unique;
        // choose a pivot
        Random random = new Random();
        int pivot = 0;
        int indexWanted = unique.length - k;
        int left = 0, right = unique.length - 1;
        do {
            pivot = left + random.nextInt(right - left);
            pivot = partition(left, right, pivot);
            if (pivot < indexWanted) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        } while (pivot != indexWanted && left < right);

        return Arrays.copyOfRange(unique, indexWanted, unique.length);
    }

    private int partition(int left, int right, int pivot) {
        swap(right, pivot);
        Integer pFreq = map.get(unique[right]);
        int curr = left;
        for (int i = left; i <= right; i++) {

            if (map.get(unique[i]) < pFreq) {
                swap(curr, i);
                curr++;
            }
        }
        swap(curr, right);
        return curr;
    }

    private void swap(int a, int b) {
        Integer temp = unique[a];
        unique[a] = unique[b];
        unique[b] = temp;
    }
}
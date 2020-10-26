import java.util.ArrayList;
import java.util.List;

public class NumberSequence {
    public static void main(String[] args) {
        int low = 10;
        int high = 1000;
        try {
            System.out.println(sequentialDigits(low, high));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<Integer>();
        for (int j = (int) Math.log10(low); j <= (int) Math.log10(high); j++)
            for (int i = 1; i < 9; i++) {
                addNumber(i, low, high, list, j);
            }
        return list;
    }

    private static void addNumber(int num, int low, int high, List<Integer> list, int depth) {
        if (num >= low && num <= high && depth == 0)
            list.add(num);
        if (num < high && num % 10 != 9 && depth > 0)
            addNumber(num * 10 + ((num % 10) + 1), low, high, list, --depth);
    }
}

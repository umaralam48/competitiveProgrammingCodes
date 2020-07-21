import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetrolPump {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (y.hasNext()) {
            list.add(y.nextInt());
        }

        System.out.println(minTime(list));
    }

    private static int minTime(List<Integer> list) {
        int sum = 0;
        for (int tank : list)
            sum += tank;
        boolean mem[][] = new boolean[list.size() + 1][sum + 1];
        // 0 sum true
        for (int i = 0; i < mem.length; i++) {
            mem[i][0] = true;
        }
        for (int i = 1; i < mem.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                mem[i][j] = mem[i - 1][j];
                if (list.get(i - 1) <= j)
                    mem[i][j] |= mem[i - 1][j - list.get(i - 1)];
            }
        }
        for (int i = sum / 2; i >= 0; i--) {
            if (mem[list.size()][i]) {
                return sum - i;
            }
        }
        return 0;
    }
}

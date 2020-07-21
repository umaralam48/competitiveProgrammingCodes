import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Swayamvar {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        // Scanner y = new Scanner(System.in);
        int n = y.nextInt();
        y.nextLine();
        char[] b = y.nextLine().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : y.nextLine().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        for (int i = 0; i < n; i++) {
            if (map.get(b[i]) <= 0) {
                left = n - i;
                break;
            }
            map.put(b[i], map.getOrDefault(b[i], 1) - 1);
        }
        System.out.println(left);
    }
}
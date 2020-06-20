import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CollisonCourse {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader y = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader y = new BufferedReader(new FileReader("test.txt"));
        int n = Integer.parseInt(y.readLine());
        double[][] cars = new double[n][3];
        for (int i = 0; i < n; i++) {
            String s[] = y.readLine().split(" ");
            cars[i][0] = Double.parseDouble(s[0]);
            cars[i][1] = Double.parseDouble(s[1]);
            cars[i][2] = Double.parseDouble(s[2]);
        }
        System.out.println(getCollisons(cars));
    }

    private static int getCollisons(double[][] cars) {
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < cars.length; i++) {
            double distoOrigin = cars[i][0] * cars[i][0] + cars[i][1] * cars[i][1];
            double t = distoOrigin / (cars[i][2] * cars[i][2]);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        int collisons = 0;
        for (double i : map.keySet()) {
            collisons += (map.get(i) * (map.get(i) - 1)) / 2;
        }
        // Arrays.sort(time);
        // int count = 0, collisons = 0;
        // for (int i = 0; i < time.length; i++) {
        // for (int j = i + 1; j < time.length; j++) {
        // if (Double.compare(time[i], time[j]) == 0)
        // collisons++;
        // }
        // }
        // for (int i = 1; i < time.length; i++) {
        // if (Double.compare(time[i], time[i - 1]) == 0)
        // count++;
        // else {
        // collisons += (count * (count + 1)) / 2;
        // count = 0;
        // }
        // }
        // collisons += (count * (count + 1)) / 2;
        // count = 0;
        return collisons;
    }
}
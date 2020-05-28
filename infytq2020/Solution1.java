import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int arr_size = Integer.parseInt(br.readLine().trim());
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[arr_size];
            for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
                arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }

            int out_ = MinimizeTheCost(arr);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }

    static int MinimizeTheCost(int[] arr) {
        // minimize the maximum of all the costs required to sort the array
        // int max=0;
        int l[] = new int[arr.length];
        int r[] = new int[arr.length];
        int min = 99999999;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            // for(int j=0;j<arr.length-1-i;j++){
            max = Math.max(max, arr[i - 1]);

            l[i] = max;
        }
        l[0] = arr[0];
        for (int i = arr.length - 2; i >= 0; i--) {
            // for(int j=0;j<arr.length-1-i;j++){
            min = Math.min(min, arr[i + 1]);
            r[i] = min;
        }
        int diff = 0;
        r[arr.length - 1] = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            // for(int j=0;j<arr.length-1-i;j++){
            int d = l[i] - r[i];
            diff = Math.max(d, diff);

        }

        // }

        return diff;

    }
}
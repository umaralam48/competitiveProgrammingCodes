public class CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        int[] a = {};
        int[][] b = {};
        System.out.println(canFormArray(a, b));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int[][] map = new int[101][];
        for (int i = 0; i < pieces.length; i++) {
            map[pieces[i][0]] = pieces[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int[] cr = map[arr[i]];
            if (cr == null) {
                return false;
            }
            for (int j = 0; j < cr.length; j++, i++) {
                if (arr[i] != cr[j])
                    return false;
            }
            i--;
        }
        return true;
    }
}

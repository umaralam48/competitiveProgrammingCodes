public class ValidMountainArray {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        System.out.println(validMountainArray(a));
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        boolean asc = false, dec = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] && asc) {
                continue;
            } else if (arr[i] < arr[i - 1] && asc) {
                dec = true;
                asc = false;
            } else if (arr[i] < arr[i - 1] && dec) {
                continue;
            } else if (arr[i] > arr[i - 1] && !asc && !dec) {
                asc = true;
            } else
                return false;
        }
        return dec ? true : false;
    }
}

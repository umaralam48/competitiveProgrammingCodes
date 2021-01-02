public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] a = { 1, 0, 0, 0, 1 };
        System.out.println(canPlaceFlowers(a, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == (flowerbed.length - 1) || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0)
                    break;
            }
        }
        return n <= 0 ? true : false;
    }
}

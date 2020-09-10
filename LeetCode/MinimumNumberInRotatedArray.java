public class MinimumNumberInRotatedArray {
    public static void main(String[] args) {
        int[] ar = {};
        System.out.println(findMin(ar));
    }

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                return nums[i];
            }
        }
        return min;
    }
}
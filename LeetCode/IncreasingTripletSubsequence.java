public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 1, 1, 1, 2 };
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first)
                first = nums[i];
            if (nums[i] > first && nums[i] < second)
                second = nums[i];
            if (nums[i] > second)
                return true;
        }
        return false;
    }
}

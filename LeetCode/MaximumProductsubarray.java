
public class MaximumProductsubarray {

    public static void main(String[] args) {
        int[] a = { -2 };
        System.out.println(maxProduct(a));
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        int neg = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                neg = curr + neg;
                curr = neg - curr;
                neg = neg - curr;
            }
            curr = Math.max(curr * nums[i], nums[i]);
            neg = Math.min(neg * nums[i], nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
}
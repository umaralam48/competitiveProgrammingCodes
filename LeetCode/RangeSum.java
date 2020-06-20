public class RangeSum {

}

class NumArray {
    int[] nums;
    int[] sums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length + 1];
        int sum = 0;
        // sums[i] is sum till i excluding i;
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            sums[i] = sum;
        }

    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
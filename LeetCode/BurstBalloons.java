public class BurstBalloons {
    public static void main(String[] args) {
        int[] a = { 1, 1, 5, 8 };
        System.out.println(maxCoins(a));
    }

    public static int maxCoins(int[] nums) {
        boolean burst[] = new boolean[nums.length];
        int ans = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                if (!burst[j] && nums[j] == i) {
                    int left = j - 1, right = j + 1;
                    while (burst[left])
                        left--;
                    while (burst[right])
                        right++;
                    ans += nums[j] * nums[left] * nums[right];
                    burst[j] = true;
                }
            }
        }
        ans += nums[0] * nums[nums.length - 1] + Math.max(nums[0], nums[nums.length - 1]);
        return ans;
    }

}

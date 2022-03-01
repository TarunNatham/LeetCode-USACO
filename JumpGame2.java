class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= nums[i - 1]; j++) {
                if(i + j < dp.length && dp[i + j] != 0) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                } else if(i + j < dp.length) {
                    dp[i + j] = dp[i] + 1;
                }
            }
        }
        return dp[n];
    }
}
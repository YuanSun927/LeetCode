public class _300_LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = 1;
        int[] dp = new int[nums.length];
        int[] max = new int[nums.length];
        dp[0] = 1;
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (max[j] < nums[i] && dp[j] > dp[i])
                    dp[i] = d[j];
            }
            if ((++dp[i]) > length)
                length = dp[i];
            max[i] = nums[i];
        }
        return length;
    }
}
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
public class _152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        int lastMax = nums[0], lastMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 此处存在重复比较，有待优化
            // Duplicate comparision exists. It can be optimized.
            int curMax = Math.max(nums[i], Math.max(lastMax * nums[i], lastMin * nums[i]));
            lastMin = Math.min(nums[i], Math.min(lastMax * nums[i], lastMin * nums[i]));
            lastMax = curMax;
            if (curMax > max)
                max = curMax;
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        int lastMax = nums[0], lastMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = lastMin;
                lastMin = lastMax;
                lastMax = temp;

            }
            lastMax = Math.max(nums[i], nums[i] * lastMax);
            lastMin = Math.min(nums[i], nums[i] * lastMin);
            if (lastMax > max)
                max = lastMax;
        }
        return max;
    }
}
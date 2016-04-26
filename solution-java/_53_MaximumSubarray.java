/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/
public class _53_MaximumSubarray {

	public int maxSubArray(int[] nums) {
        if (nums == null)
        	return 0;
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
        	if (sum < 0) {
        		if (nums[i] >= 0)
        			sum = 0;
        		else {
        			sum = sum > nums[i] ? sum : nums[i];
        		}
        	} else 	
        		sum += nums[i];
        	maxSum = sum > maxSum ? sum : maxSum;
        }
        return maxSum;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null)
            return 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
}
/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class _16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target)
                    return target;
                int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    minGap = gap;
                    result = sum;
                }
                if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}

/*
Given an array of n positive integers and a positive integer s,
find the minimal length of a subarray of which the sum ≥ s.
If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/
public class _209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 0;
        int sum = 0;
        long minLen = nums.length + 1;
        while (start < nums.length) {
            if (sum < s && end < nums.length) {
                sum += nums[end++];
            } else if (sum >= s) {
                minLen = Math.min(end - start, minLen);
                if (minLen == 1)
                    return 1;
                sum -= nums[start++];
            } else {
                break;
            }
        }
        return (int) (minLen > nums.length ? 0 : minLen);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 0;
        int sum = 0;
        long minLen = nums.length + 1;
        while (start <= end && end < nums.length) {
            while (end < nums.length && sum < s) {
                sum += nums[end++];
            }
            if (sum < s)
                break;
            while (start <= end && sum >= s) {
                sum -= nums[start++];
            }
            minLen = Math.min(end - start + 1, minLen);
            if (minLen == 1)
                return 1;
        }
        return (int) (minLen > nums.length ? 0 : minLen);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 0;
        int sum = 0;
        long minLen = nums.length + 1;
        while (end < nums.length) {
            sum += nums[end++];
            while (start < nums.length && sum >= s) {
                minLen = Math.min(end - start, minLen);
                sum -= nums[start++];
            }
            if (minLen == 1)
                return 1;
        }
        return (int) (minLen > nums.length ? 0 : minLen);
    }

}
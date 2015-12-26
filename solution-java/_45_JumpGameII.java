/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
public class _45_JumpGameII {

    public int jump(int[] nums) {
        int steps = 0;
        int last = 0;
        int cur = 0;
        for (int i = 0; i < nums.length && last < nums.length; i++) {
            if (i > last) {
                last = cur;
                steps++;
            }
            cur = Math.max(i + nums[i], cur);
        }
        return steps;
    }
}
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/
public class _268_MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        boolean[] a = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] = true;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i])
                return i;
        }
        return 0;
    }
}
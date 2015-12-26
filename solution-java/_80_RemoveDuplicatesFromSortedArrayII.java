/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
It doesn't matter what you leave beyond the new length.
*/
public class _80_RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int lastVal = nums[0];
        int index = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastVal && count < 2) {
                nums[index++] = nums[i];
                count++;
            } else if (nums[i] != lastVal) {
                nums[index++] = nums[i];
                lastVal = nums[i];
                count = 1;
            }
        }
        return index;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 3)
            return nums.length;
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }
        return index;
    }
}
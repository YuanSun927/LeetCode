/*
Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class _35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null)
            return 0;
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int low, int high) {
        if (high <= low) {
            if (target == nums[low])
                return low;
            else if (target > nums[low])
                return low + 1;
            else
                return low;
        }
        int half = (high >> 1) + (low >> 1);
        if (nums[half] == target)
            return half;
        if (target < nums[half])
            return search(nums, target, low, half - 1);
        else
            return search(nums, target, half + 1, high);
    }

}
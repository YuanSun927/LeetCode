/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class _34_SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return new int[] {-1, -1};
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                break;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (nums[mid] != target)
            return new int[] {-1, -1};
        int left1 = left, right1 = mid, mid1 = 0;
        while (left1 < right1) {
            mid1 = left1 + ((right1 - left1) >> 1);
            if (nums[mid1] == target)
                right1 = mid1 - 1;
            else
                left1 = mid1 + 1;
        }
        int left2 = mid, right2 = right, mid2 = 0;
        while (left2 < right2) {
            mid2 = left2 + ((right2 - left2) >> 1);
            if (nums[mid2] == target)
                left2 = mid2 - 1;
            else
                right2 = mid2 + 1;
        }
        return new int[] {left1, left2};
    }
}
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
public class _33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 2);
            if (target == nums[mid])
                return mid;
            if (nums[mid] >= nums[0]) {
                if (target < nums[mid] && target >= nums[0])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target > nums[mid] && target < nums[0])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
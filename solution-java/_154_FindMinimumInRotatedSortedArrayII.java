/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/
public class _154_FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums[nums.length - 1] > nums[0] || nums.length == 1)
            return nums[0];
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[high])
                low = mid + 1;
            else if (nums[mid] < nums[high])
                high = mid;
            else
                high--;
        }
        return nums[low];
    }
}
/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/
public class _287_FindTheDuplicateNumber {
    
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int n = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > mid && nums[i] <= high)
                    n++;
            }
            if (n > (high - mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
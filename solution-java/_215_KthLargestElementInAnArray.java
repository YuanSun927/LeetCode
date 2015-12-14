/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
public class _215_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k)
            return 0;
        return findK(nums, k, 0, nums.length - 1);
    }

    private int findK(int[] nums, int k, int low, int high) {
        if (low == high)
            return nums[low];
        int pivot = partition(nums, low, high);
        if (k == pivot + 1)
            return nums[pivot];
        if (k < pivot + 1)
            return findK(nums, k, low, pivot - 1);
        else
            return findK(nums, k, pivot + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] > nums[high]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
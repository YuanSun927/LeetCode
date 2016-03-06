/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
public class _31_NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int lastASC = -1;
        int exchanged = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                lastASC = i;
            }
            if (lastASC != -1 && nums[i] > nums[lastASC]) {
                exchanged = i;
            }
        }
        if (exchanged != -1) {
            exchange(nums, lastASC, exchanged);
        }
        for (int i = 1; i <= (nums.length - lastASC) / 2; i++) {
            exchange(nums, lastASC + i, nums.length - i);
        }
    }

    public void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
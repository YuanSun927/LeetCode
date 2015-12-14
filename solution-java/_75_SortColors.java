public class _75_SortColors {
    
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        for (int i = 0; i <= two; i++) {
            while (nums[i] == 2 && i < two)
                swap(nums, i, two++);
            while (nums[i] == 0 && i > zero)
                swap(nums, i, zero++);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
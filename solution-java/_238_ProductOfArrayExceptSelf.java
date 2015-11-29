/*
Given an array of n integers where n > 1, nums, return an array output such that 
output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/
public class _238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int numOfZero = 0;
        int zeroIndex = -1;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numOfZero++;
                zeroIndex = i;
                if (numOfZero > 1)
                    return new int[nums.length];
            } else {
                product *= nums[i];
            }
        }
        int[] products = new int[nums.length];
        if (numOfZero > 0) {
            products[zeroIndex] = product;
        } else {
            for (int i = 0; i < nums.length; i++) {
                products[i] = product / nums[i];
            }
        }
        return products;
    }
}
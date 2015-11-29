/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class _137_SingleNumberII {
	
	public int singleNumber(int[] nums) {
        int[] b = new int[32];
        int single = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                b[i] += ((nums[j] >> i) & 1); 
            }
        }
        for (int i = 0; i < 32; i++) {
            single |= ((b[i] % 3) << i);
        }
        return single;        
    }
}
/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:
How many majority elements could it possibly have?
*/
public class _229_MajorityElementII {
    
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return result;
        int m1 = nums[0];
        int t1 = 1;
        for (int i = 1; i < nums.length; i++) {
            m1 == nums[i] ? t1++ : t1--;
            if (t1 == 0) {
                m1 = nums[i];
                t1 = 1;
            }
        }
        
        int m2 = nums[0];
        t1 = nums[0] == m1 ? 1 : 0;
        int t2 = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == m1) {
                t1++;
            } else {
                m2 == nums[i] ? t2++ : t2--;
                if (t2 == 0) {
                    m1 = nums[i];
                    t2 = 1;
                }
            }
        }
        if (t1 > nums.length / 3) {
            result.add(t1);
            t2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == m2) {
                    t2++;
                } 
            }
            if (t2 > nums.length / 3) {
                result.add(m2);
            } 
        }
        return result;
    }
}
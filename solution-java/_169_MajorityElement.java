package com.yuan.leetcode;

import java.util.Arrays;

public class _169_MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int element = nums[0];
        int num = 1;
        for (int i =1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                num++;
                if (num > nums.length / 2) {
                    element = nums[i];
                    break;
                }
            } else {
                num = 1;
            }
        }
        return element;
    }
    
    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 2, 5, 4, 5, 6, 2, 2};
        int[] nums = {2, 2, 2, 2, 1, 1, 1};
        System.out.println(new _169_MajorityElement().majorityElement(nums));

    }

}

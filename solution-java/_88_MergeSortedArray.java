/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
public class _88_MergeSortedArray {
    
    public void merge1(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        for (; i >= 0 && j >= 0; k--) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
        if (i < 0) {
            for (int t = 0; t <= k; t++) {
                nums1[t] = nums2[t];
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n){
        while (n > 0)
            nums1[m + n - 1] = (m == 0 || nums2[n - 1] > nums1[m - 1]) ? nums2[--n] : nums1[--m];
    }
}
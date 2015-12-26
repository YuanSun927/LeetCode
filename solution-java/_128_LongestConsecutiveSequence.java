/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class _128_LongestConsecutiveSequence {
    
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]))
                continue;
            set.remove(nums[i]);
            int length = 1;
            int left = nums[i] - 1, right = nums[i] + 1;
            while (set.contains(left)) {
                length++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                length++;
                set.remove(right);
                right++;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}
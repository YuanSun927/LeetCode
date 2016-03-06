/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class _78_Subsets {

    // Backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null)
            return result;
        Arrays.sort(nums);
        result.add(new LinkedList<>());
        for (int i = 1; i <= nums.length; i++) {
            subsets(result, nums, i);
        }
        return result;
    }

    private void subsets(List<List<Integer>> result, int[] nums, int size) {
        subsets(result, new LinkedList<>(), nums, size, 0, nums.length - size);
    }

    private void subsets(List<List<Integer>> result, List<Integer> subset, int nums[], int r, int start, int end) {
        if (r == 0) {
            result.add(subset);
            return;
        }
        for (int i = start; i <= end; i++) {
            subset.add(nums[i]);
            subsets(result, subset, nums, r - 1, start + 1, end + 1);
            subset.remove(subset.size() - 1);
        }
    }

    // Bit manipulation
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null)
            return result;
        Arrays.sort(nums);
        int mask = 1 << nums.length;
        for (int i = 0; i < mask; i++) {
            List<Integer> subset = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((1 << j) & i) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null)
            return result;
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n = result.size();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
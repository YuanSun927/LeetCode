/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class _90_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null)
            return result;
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            subsets(nums, i, 0, new ArrayList<Integer>(), result);
        }
        return result;
    }

    private void subsets(int[] nums, int r, int start, List<Integer> subset, List<List<Integer>> result) {
        if (r == 0) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        for (int i = start; i <= nums.length - r; i++) { // 扩展状态
            if (i > start && nums[i] == nums[i - 1]) // 剪枝
                continue;
            subset.add(nums[i]); // 执行扩展动作
            subsets(nums, r - 1, i + 1, subset, result);
            subset.remove(subset.size() - 1); // 撤销动作
        }
    }
}
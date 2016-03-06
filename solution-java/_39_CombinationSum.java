/*
Given a set of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class _39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null)
            return result;
        Arrays.sort(candidates);
        sum(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void sum(int[] cand, int target, int start, List<Integer> c, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(c));
            return;
        }
        for (int i = start; i < cand.length; i++) { // 扩展状态
            if (target < cand[i]) // 剪枝
                return;
            c.add(cand[i]); // 执行扩展动作
            sum(cand, target - cand[i], i, c, result);
            c.remove(c.size() -1); // 撤销动作
        }
    }
}
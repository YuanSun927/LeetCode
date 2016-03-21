/*
Find all possible combinations of k numbers that add up to a number n,
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.

Example 1:
Input: k = 3, n = 7
Output:
[[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]
*/
public class _216_CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 1 || k > 9 || n < 1 || n > 45)
            return result;
        List<Integer> temp = new ArrayList<>();
        combSum(k, n, 1, temp, 0, result);
        return result;
    }

    private void combSum(int k, int n, int start, List<Integer> temp, int sum, List<List<Integer>> result) {
        if (start > 10 || sum > n || temp.size() > k)
            return;
        if (temp.size() == k && sum == n) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            sum += i;
            temp.add(i);
            combSum(k, n, i + 1, temp, sum, result);
            temp.remove(temp.size() - 1);
            sum -= i;
        }
    }

}
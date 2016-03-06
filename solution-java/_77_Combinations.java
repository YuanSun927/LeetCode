/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class _77_Combinations {

    // C(n,k)=C(n-1,k-1)+C(n-1,k)
    public List<List<Integer>> combine(int n, int k) {
        if (n == k || k == 0) {
            List<Integer> c = new LinkedList<>();
            for (int i = 1; i <= k; i++) {
                c.add(i);
            }
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            result.add(c);
            return result;
        }
        List<List<Integer>> combinations = combine(n - 1, k - 1);
        for (List<Integer> c : combinations) {
            c.add(n);
        }
        combinations.addAll(combine(n - 1, k));
        return combinations;
    }

    // Backtracking
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        combine(result, new LinkedList<Integer>(), k, 1, n - k + 1);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> c, int r, int from, int to) {
        if (r == 0) {
            result.add(new LinkedList<Integer>(c));
            return;
        }
        for (int i = from; i <= to; i++) {
            c.add(i);
            combine(result, c, r - 1, i + 1, to + 1);
            c.remove(c.size() - 1);
        }
    }
}
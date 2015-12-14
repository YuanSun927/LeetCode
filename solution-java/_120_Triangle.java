/*
Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space,
where n is the total number of rows in the triangle.
*/
public class _120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return -1;
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int level = 1; level < triangle.size(); level++) {
            List<Integer> levelList = triangle.get(level);
            dp[level] = dp[level - 1] + levelList.get(level);
            for (int i = level - 1; i > 0; i--) {
                dp[i] = Math.min(dp[i - 1], dp[i]) + levelList.get(i);
            }
            dp[0] += levelList.get(0);
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
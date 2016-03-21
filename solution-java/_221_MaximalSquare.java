/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
public class _221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int[] dp = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = matrix[0][i] - '0';
            if (dp[i] == 1)
                max = 1;
        }
        for (int i = 1; i < matrix.length; i++) {
            int prev = dp[0];
            dp[0] = matrix[i][0] - '0';
            for (int j = 1; j < dp.length; j++) {
                int temp = dp[j];
                dp[j] = matrix[i][j] == '1' ? Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1 : 0;
                if (dp[j] > max) {
                    max = dp[j];
                }
                prev = temp;
            }
        }
        return max * max;
    }
}
/*
Given a positive integer n, find the least number of perfect square numbers
(for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
given n = 13, return 2 because 13 = 4 + 9.
*/
public _279_PerfectSquares {
    
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int root = (int) Math.sqrt(i);
            if (i == root * root) {
                dp[i] = 1;
            } else {
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
                }
            }
        }
        return dp[n];
    }
}
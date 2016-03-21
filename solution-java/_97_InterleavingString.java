/*
97. Interleaving String My Submissions Question
Total Accepted: 46736 Total Submissions: 210532 Difficulty: Hard
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
public class _97_InterleavingString {

    // Space O(n^2)
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j + 1] = s2.charAt(j) == s3.charAt(j) && dp[0][j];
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // Space O(n)
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;
        for (int j = 0; j < s2.length(); j++) {
            dp[j + 1] = s2.charAt(j) == s3.charAt(j) && dp[j];
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (j == 0) {
                    dp[0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[0];
                } else {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }   
            }
        }
        return dp[s2.length()];
    }
}
/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
public class _10_RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int sPos, String p, int pPos) {
        if (pPos >= p.length()) {
            return sPos >= s.length();
        }
        if (pPos < p.length() - 1 && p.charAt(pPos + 1) == '*') {
            while (s.charAt(sPos) == p.charAt(pPos)) {
                if (isMatch(s, sPos++, p, pPos + 2))
                    return true;
            }
            return isMatch(s, sPos, p + 2);
        } else {
            if (s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '.')
                return isMatch(s, sPos + 1, p, pPos + 1);
            return false;
        }
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = ; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
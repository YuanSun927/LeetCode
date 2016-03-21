/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/
public class _44_WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int sPos, String p, int pPos) {
        if (pPos >= p.length())
            return sPos >= s.length();
        if (p.charAt(pPos) == '?')
            return isMatch(s, sPos + 1, p, pPos + 1);
        if (p.charAt(pPos) == '*') {
            if (pPos == p.length() - 1)
                return true;
            while (sPos < s.length()) {
                if (isMatch(s, sPos++, p, pPos + 1))
                    return true;
            }
            return false;
        }
        if (sPos < s.length() && s.charAt(sPos) == p.charAt(pPos)) {
            return isMatch(s, sPos + 1, p, pPos + 1);
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        int match = 0, startIdx = -1;
        int sPos = 0, pPos = 0;
        while (sPos < s.length()) {
            if (pPos < p.length() && (p.charAt(pPos) == '?' || s.charAt(sPos) == p.charAt(pPos))) {
                sPos++;
                pPos++;
            } else if (pPos < p.length() && p.charAt(pPos) == '*') {
                startIdx = pPos;
                match = sPos;
                pPos++;
            } else if (startIdx != -1) {
                pPos = startIdx + 1;
                match++;
                sPos = match;
            } else
                return false;
        }
        while (pPos < p.length() && p.charAt(pPos) == '*')
            pPos++;
       return pPos == p.length();
   }
}
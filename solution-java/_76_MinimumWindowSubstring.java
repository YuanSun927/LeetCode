/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
public class _76_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            Integer n = map.get(t.charAt(i));
            if (n == null)
                n = 0;
            map.put(t.charAt(i), n + 1);
        }
        int start = 0, end = 0;
        int count = t.length();
        int minStart = 0, minLen = s.length() + 1;
        while (end < s.length()) {
            char cur = s.charAt(end++);
            if (map.containsKey(cur)) {
                int n = map.get(cur);
                if (n > 0)
                    count--;
                map.put(cur, n - 1);
            }
            while (start < s.length() && count == 0) {
                int len = end - start;
                if (len < minLen) {
                    minLen = len;
                    minStart = start;
                }
                char startChar = s.charAt(start++);
                if (map.containsKey(startChar)) {
                    int n = map.get(startChar);
                    if (n == 0)
                        count++;
                    map.put(startChar, n + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(minStart, minStart + minLen);
    }
}
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
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), 0);
        }
        int head = 0;
        while (head < s.length() && !map.containsKey(s.charAt(head)))
            head++;
        if (head >= s.length())
            return "";
        int found = 0;
        int minSize = Integer.MAX_VALUE;
        String minWinStr = "";
        for (int i = head; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                int k = map.get(cur);
                found += map.get(cur) == 0 ? 1 : 0;
                map.put(cur, k + 1);
            }
            if (found == map.size()) {
                while (head < i) {
                    if (!map.containsKey(s.charAt(head))) {
                        head++;
                    } else if (map.get(s.charAt(head)) > 1) {
                        map.put(s.charAt(head), map.get(s.charAt(head)) - 1);
                        head++;
                    } else {
                        break;
                    }
                }
                if (i - head + 1 < minSize) {
                    minSize = i - head + 1;
                    minWinStr = s.substring(head, i + 1);
                }
            }
        }
        return minWinStr;
    }
}
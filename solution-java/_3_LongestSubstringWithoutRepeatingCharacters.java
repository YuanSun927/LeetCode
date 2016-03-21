/*
Given a string, find the length of the longest substring without repeating characters.
For example, the longest substring without repeating letters for "abcabcbb" is "abc",
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int maxLen = 0, len = 0;
        Set<Character> subStr = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!subStr.contains(cur)) {
                subStr.add(cur);
                len++;
                if (len > maxLen)
                    maxLen = len;
            } else {
                for (int j = start; j < end; j++) {
                    char c = s.charAt(j);
                    start++;
                    if (cur != c) {
                        subStr.remove(c);
                        len--;
                    } else
                        break;
                }
            }
            end++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int maxLen = 0, len = 0;
        Set<Character> subStr = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!subStr.contains(cur)) {
                subStr.add(cur);
                len++;
                if (len > maxLen)
                    maxLen = len;
            } else {
                char c;
                while ((c = s.charAt(start++)) != cur) {
                    subStr.remove(c);
                    len--;
                }
            }
            end++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLen = 0;
        Map<Character, Integer> subStr = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            Integer pos = subStr.get(cur);
            if (pos != null) {
                start = Math.max(pos + 1, start);
            }
            subStr.put(cur, i);
            maxLen = Math.max(i - start + 1, maxLen);
        }
        return maxLen;
    }
    
}
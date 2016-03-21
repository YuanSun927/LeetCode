/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class _131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        List<String> part = new ArrayList<>();
        partition(s, 0, part, result);
        return result;
    }

    private void partition(String s, int start, List<String> part, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(part));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i + 1); // 每次调用substring()取子串验证是否回文较为耗时
            if (isPalindrome(subStr)) {
                part.add(subStr);
                partition(s, i + 1, part, result);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    // 改进版
    // 每次调用substring()取子串验证是否回文较为耗时
    // 改进方案为在源字符串中验证[i, j]这一段是否回文，若是，则调用substring()取出子串。
    private void partition(String s, int start, List<String> part, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(part));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                part.add(s.substring(start, i + 1));
                partition(s, i + 1, part, result);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }
}
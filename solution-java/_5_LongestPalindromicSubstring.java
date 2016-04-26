/*
Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class _5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return "";
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length();) {
            if (i + maxLen / 2 >= s.length())
                break;
            int j = i, k = i;
            while (k < s.length() - 1 && s.charAt(k + 1) == s.charAt(k))
                k++;
            i = k + 1;
            while (k < s.length() - 1 && j > 0 && s.charAt(k + 1) == s.charAt(j - 1)) {
                k++;
                j--;
            }
            int len = k - j + 1;
            if (len > maxLen) {
                start = j;
                maxLen = len;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public String longestPalindrome(String s) {
        StringBuilder str = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i)).append('#');
        }
        int prMax = 0;
        int pos = 0;
        int[] len = new int[str.length()];
        int lengthMax = 0, maxPos = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i < prMax) {
                len[i] = Math.min(len[2 * pos - i], prMax - i);
            } else {
                len[i] = 1;
            }
            while (i - len[i] >= 0 && i + len[i] < str.length() && str.charAt(i + len[i]) == str.charAt(i - len[i]))
                len[i]++;
            if (len[i] + i> prMax) {
                prMax = len[i] + i;
                pos = i;
            }
            if (len[i] > lengthMax) {
                lengthMax = len[i];
                maxPos = i;
            }
        }
        StringBuilder p = new StringBuilder();
        int start = maxPos - lengthMax + 1;
        int end = start + 2 * lengthMax - 2;
        for (int i = start; i <= end; i++) {
            if (i % 2 == 1) {
                p.append(str.charAt(i));
            }
        }
        return p.toString();
    }

    public String longestPalindrome(String s) {
        char[] str = new char[s.length() * 2 + 1];
        for (int i = 0; i < str.length; i += 2) {
            str[i] = '#';
            str[i + 1] = s.charAt[i];
        }
        str[str.length - 1] = '#';
        int prMax = 0;
        int pos = 0;
        int[] len = new int[str.length];
        int lengthMax = 0, maxPos = 0;
        for (int i = 0; i < str.length; i++) {
            if (i < prMax) {
                len[i] = Math.min(len[2 * pos - i], prMax - i);
            } else {
                len[i] = 1;
            }
            while (i - len[i] >= 0 && i + len[i] < str.length && str[i + len[i]] == str[i - len[i]])
                len[i]++;
            if (len[i] + i> prMax) {
                prMax = len[i] + i;
                pos = i;
            }
            if (len[i] > lengthMax) {
                lengthMax = len[i];
                maxPos = i;
            }
        }
        StringBuilder p = new StringBuilder();
        int start = maxPos - lengthMax + 1;
        int end = start + 2 * lengthMax - 2;
        for (int i = start; i <= end; i++) {
            if (i % 2 == 1) {
                p.append(str[i]));
            }
        }
        return p.toString();
    }

    public String longestPalindrome(String s) {
        if (s==null || s.length()==0)
            return "";
        
        char[] s2 = addBoundaries(s.toCharArray()); // Optimize
        int[] p = new int[s2.length]; 
        int c = 0, r = 0; // Here the first element in s2 has been processed.
        int m = 0, n = 0; // The walking indices to compare if two elements are the same
        for (int i = 1; i < s2.length; i++) {
            if (i > r) {
                p[i] = 0;
                m = i - 1;
                n = i + 1;
            } else {
                int i2 = c * 2 - i;
                if (p[i2] < (r - i)) {
                    p[i] = p[i2];
                    m = -1; // This signals bypassing the while loop below. 
                } else {
                    p[i] = r-i;
                    n = r + 1;
                    m = i * 2 - n;
                }
            }
            while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
                p[i]++;
                m--;
                n++;
            }
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        int len = 0;
        int c = 0;
        for (int i = 1; i < s2.length; i++) {
            if (len < p[i]) {
                len = p[i];
                c = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, c-len, c+len+1);
        return String.valueOf(removeBoundaries(ss));
    }
 
    private char[] addBoundaries(char[] cs) {
        if (cs == null || cs.length==0)
            return "||".toCharArray();

        char[] cs2 = new char[cs.length*2+1];
        for (int i = 0; i<(cs2.length-1); i = i+2) {
            cs2[i] = '|';
            cs2[i+1] = cs[i/2];
        }
        cs2[cs2.length-1] = '|';
        return cs2;
    }

    private char[] removeBoundaries(char[] cs) {
        if (cs==null || cs.length<3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length-1)/2];
        for (int i = 0; i<cs2.length; i++) {
            cs2[i] = cs[i*2+1];
        }
        return cs2;
    }
}
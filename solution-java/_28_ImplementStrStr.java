/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class _28_ImplementStrStr {

    // Brute force
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;
        if (needle.length() == 0)
            return 0;
        int hPos = 0, nPos = 0;
        while (hPos + nPos < haystack.length()) {
            if (haystack.charAt(hPos + nPos) == needle.charAt(nPos)) {
                if (nPos == needle.length() - 1)
                    return hPos;
                nPos++;
            } else {
                hPos++;
                nPos = 0;
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length())
                    return i;
                if (i + j == haystack.length())
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }

    // KMP
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;
        if (needle.length() == 0)
            return 0;
        int[] next = getNextArray(needle);
        int hPos = 0, nPos = 0;
        while (hPos + nPos < haystack.length()) {
            if (needle.charAt(nPos) == haystack.charAt(hPos + nPos)) {
                if (nPos == needle.length() - 1)
                    return hPos;
                nPos++;
            } else {
                if (next[nPos] > -1) {
                    hPos = hPos + nPos - next[nPos];
                    nPos = next[nPos];
                } else {
                    nPos = 0;
                    hPos++;
                }
            }
        }
        return -1;
    }

    private int[] getNextArray(String t) {
        if (t.length() == 1) {
            return new int[] {-1};
        }
        int[] next = new int[t.length()];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int pos = 2;
        while (pos < t.length()) {
            if (t.charAt(pos - 1) == t.charAt(cn)) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}
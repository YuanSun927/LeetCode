/*
165. Compare Version Numbers My Submissions Question
Total Accepted: 47425 Total Submissions: 278059 Difficulty: Easy
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/
public class _165_CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int minLen = 0, maxLen = 0;
        if (v1.length < v2.length) {
            minLen = v1.length;
            maxLen = v2.length;
        } else {
            minLen = v2.length;
            maxLen = v1.length;
        }
        for (int i = 0; i < minLen; i++) {
            int vs1 = Integer.parseInt(v1[i]);
            int vs2 = Integer.parseInt(v2[i]);
            if (vs1 != vs2)
                return Integer.compare(vs1, vs2);
        }
        String[] vLong = v1.length > v2.length ? v1 : v2;
        for (int i = minLen; i < maxLen; i++) {
            if (Integer.parseInt(vLong[i]) != 0) {
                return v1.length > v2.length ? 1 : -1;
            }
        }
        return 0;
    }
}
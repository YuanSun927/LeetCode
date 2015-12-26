/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j])
where the two words do not share common letters.
You may assume that each word will contain only lower case letters.
If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/
public class _318_MaximumProductOfWordLengths {
        
    public int maxProduct(String[] words) {
        int[] arr = new int[26];
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                arr[word.charAt(i) - 'a'] = Math.max(arr[word.charAt(i) - 'a'], length);
            }
        }
        int[] top = new int[2];
        for (int i = 0; i < 26; i++) {
            if (arr[i] > top[0]) {
                top[1] = top[0];
                top[0] = arr[i];
            } else if (arr[i] > top[1] && arr[i] < top[0]) {
                top[1] = arr[i];
            }
        }
        return top[0] * top[1];
    }
}
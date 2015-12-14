/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/
public class _125_ValidPalindrome {
    
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i < j && !isAlphaNum(s.charAt(i)))
                i++;
            while (i < j && !isAlphaNum(s.charAt(j)))
                j--;
            if (i < j && !isEqualChar(s.charAt(i), s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isEqualChar(char c1, char c2) {
        return c1 == c2 || (c1 - 'A') == (c2 - 'a') || (c1 - 'a') == (c2 - 'A');
    }

    private boolean isAlphaNum(char c) {
        return (c >= 'a' && c <='z') || (c >= 'A' && c <='Z') || (c >= '0' && c <= '9');
    }
}
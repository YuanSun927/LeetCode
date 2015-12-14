/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. 
However, if you have solved the problem "Reverse Integer", 
you know that the reversed integer might overflow. 
How would you handle such case?

There is a more generic way of solving this problem.P
*/
public class _9_PalindromeNumber {
    
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int i = 1;
        while (x / i >= 10)
            i *= 10;
        while (x >= 10) {
            if ( x / i != x % 10)
                return false;
            x = x % i / 10;
            i /= 100;
        }
        return i == 0 || i == 1 || x == 0;
    }
}
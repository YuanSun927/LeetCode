/*
Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.
*/
public class _172_FactorialTrailingZeroes {

	public int trailingZeroes(int n) {
        int z = 0;
        while (n != 0) {
        	z += n / 5;
        	n /= 5;
        }
        return z;
    }
}
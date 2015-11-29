/*
 * Given an integer, write a function to determine if it is a power of two.
 */
public class _231_PowerOfTwo {

	public boolean isPowerOfTwo1(int n) {
        if (n < 0 || n == 0)
        	return false;
        int i = 0;
        for (i = 0; n != 0; i++) {
        	n &= (n - 1);
        }
        return i == 1;
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 0 || n == 0)
        	return false;
        return (n &= (n - 1)) == 0;
    }
}
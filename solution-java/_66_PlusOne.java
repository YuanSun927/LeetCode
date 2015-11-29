/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.
*/
public class _66_PlusOne {

	public int[] plusOne1(int[] digits) {
        if (digits == null)
        	return null;
        if ((++digits[digits.length - 1]) < 10)
        	return digits;
        boolean c = true; // carry
        digits[digits.length - 1] = 0;
        for (int i = digits.length - 2; i >= 0; i--) {
        	if (!c)
        		break;
        	c = ((++digits[i]) > 9);
        	if (c)
        		digits[i] = 0;
        }
        int[] result = null;
        if (c) {
        	result = new int[digits.length + 1];
        	result[0] = 1;
        	for (int i = 1; i < result.length; i++) {
        		result[i] = digits[i - 1];
        	}
        	return result;
        } else
        	return digits;
    }

    public int[] plusOne(int[] digits) {
        if (digits == null)
        	return null;
        for (int i = digits.length - 1; i >= 0; i--) {
        	if (digits[i] == 9) {
        		digits[i] = 0;
        	} else {
        		digits[i]++;
        		return digits;
        	}
        }
        int[] a = new int[digits.length + 1];
        a[0] = 1;
        return a;
    }
}
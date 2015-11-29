/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class _191_NumberOf1Bits {

	public int hammingWeight(int n) {
		int a = 0;
		int weight = 0;
		for (int i = 0; i < 32; i++) {
			a = 1 << i;
			if ((n & a) != 0) {
				weight++;
			}
		}
		return weight;
	}
}
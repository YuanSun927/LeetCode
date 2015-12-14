/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
*/
public class _190_ReverseBits {

    private int[] reverseHex = new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        while (n != 0) {
            rev = (rev << 4) + reverseHex[n & 0xF];
            n >>>= 4;
        }
        return rev;
    }
}
/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/
public class _89_GrayCode {

    // reflected binary code
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(1 << n);
        result.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                int msb = 1 << i;
                result.add(result.get(j) + msb);
            }
        }
        return result;
    }

    public List<Integer> grayCode1(int n) {
        int size = 1 << n;
        List<Integer> result = new ArrayList<>(size);
        result.add(0);
        for (int i = 1; i < size; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}
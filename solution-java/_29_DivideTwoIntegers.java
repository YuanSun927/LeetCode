/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/
public class _29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int div = 0;
        while (a >= b) {
            int multi = 1;
            long bb = b;
            while (a >= bb) {
                a -= bb;
                bb += bb;
                div += multi;
                multi += multi;
            }
        }
        return isNeg ? -div : div;
    }
}
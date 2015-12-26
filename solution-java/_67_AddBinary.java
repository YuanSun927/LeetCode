/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class _67_AddBinary {

    public String addBinary(String a, String b) {
        int bitA = 0, bitB = 0, carry = 0;
        StringBuffer sumStr = new StringBuffer("");
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            bitA = i < 0 ? 0 : (a.charAt(i--) - '0');
            bitB = j < 0 ? 0 : (b.charAt(j--) - '0');
            int sum = bitA + bitB + carry;
            char sumChar = sum == 0 || sum == 2 ? '0' : '1';
            sumStr.append(sumChar);
            carry = sum > 1 ? 1 : 0;
        }
        if (carry == 1)
            sumStr.append('1');
        return sumStr.length() == 0 ? "0" : sumStr.reverse().toString();
    }
}
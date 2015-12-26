/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class _12_IntegerToRoman {

    public String intToRoman(int num) {
        int[] radix = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer roman = new StringBuffer("");
        for (int i = 0; num > 0; i++) {
            int count = num / radix[i];
            num %= radix[i];
            for (int j = 0; j < count; j++)
                roman.append(symbol[i]);
        }
        return roman.toString();
    }
}

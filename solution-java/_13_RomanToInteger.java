/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class _13_RomanToInteger {

	public int romanToInt(String s) {
		int[] a = new int[26];
		a['I' - 'A'] = 1;
		a['V' - 'A'] = 5;
		a['X' - 'A'] = 10;
		a['L' - 'A'] = 50;
		a['C' - 'A'] = 100;
		a['D' - 'A'] = 500;
		a['M' - 'A'] = 1000;
		int status = 1;
		int num = 0;
        for (int i = s.length() - 1; i >=0; i--) {
        	char c = s.charAt(i);
        	int delta = a[c - 'A'];
        	if (delta >= status) {
        		num += delta;
        		status = delta;
        	} else {
        		num -= delta;
        	}
        }
        return num;
    }
}
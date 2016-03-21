/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class _6_ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows < 2 || s == null) 
            return s;
        StringBuilder[] strs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strs[i] = new StringBuilder("");
        }
        int len = 0, row = 0;
        boolean isAsc = true;
        while (len < s.length()) {
            strs[row].append(s.charAt(len));
            len++;
            if ((row == 0 && !isAsc) || (row == numRows - 1 && isAsc)) {
                isAsc = !isAsc;
            }
            row = isAsc ? ++row : --row;
        }
        for (int i = 1; i < numRows; i++) {
            strs[0].append(strs[i]);
        }
        return strs[0].toString();
    }

    public String convert(String s, int numRows) {
        if (numRows < 2 || s == null) 
            return s;
        StringBuilder[] strs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strs[i] = new StringBuilder("");
        }
        int len = 0, row = 0;
        while (len < s.length()) {
            for (int i = 0; len < s.length() && i < numRows; i++) {
                strs[i].append(s.charAt(len++));
            }
            for (int i = numRows - 2; len < s.length() && i > 0; i--) {
                strs[i].append(s.charAt(len++));
            }
        }
        for (int i = 1; i < numRows; i++) {
            strs[0].append(strs[i]);
        }
        return strs[0].toString();
    }

    public String convert(String s, int numRows) {
        if (numRows < 2 || s == null) 
            return s;
        StringBuilder str = new StringBuilder();
        int cycle = 2 * numRows - 2; 
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += cycle) {
                str.append(s.charAt(j));
                int second = j + (numRows - i - 1) * 2;
                if (i != 0 && i != numRows - 1 && second < s.length()) {
                    str.append(s.charAt(second));
                }
            }
        }
        return str.toString();
    }

}
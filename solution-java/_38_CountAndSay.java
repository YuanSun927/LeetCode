/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class _38_CountAndSay {
    
    public String countAndSay(int n) {
        if (n < 1)
            return null;
        String str = "1";
        for (int i = 2; i <= n; i++) {
            str = countAndSay(str);
        }
        return str;
    }

    public String countAndSay(String str) {
        char last = str.charAt(0);
        int num = 1;
        StringBuffer countStr = new StringBuffer("");
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last)
                num++;
            else {
                countStr = countStr.append(num).append(last);
                num = 1;
                last = str.charAt(i);
            }
        }
        return countStr.append(num).append(last).toString();
    }
}
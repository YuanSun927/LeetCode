/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/
public class _43_MultiplyStrings {

    public String multiply(String num1, String num2) {
        String[] temp = new String[10];
        List<String> parts = new ArrayList<>();
        for (int i = 0; i < num2.length(); i++) {
            int charIndex = num2.charAt(num2.length() - i - 1) - '0';
            if (charIndex != 0 && temp[charIndex] == null) {
                temp[charIndex] = multiply(num1, charIndex);
            }
            if (charIndex != 0 && !temp[charIndex].equals("0")) {
                StringBuilder part = new StringBuilder(temp[charIndex]);
                for (int j = 0; j < i; j++) {
                    part.append('0');
                }
                parts.add(part.toString());
            }
        }
        return sum(parts);
    }

    private String multiply(String num, int n) {
        StringBuilder str = new StringBuilder();
        int c = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int mul = (num.charAt(i) - '0') * n + c;
            c = mul / 10;
            str.append(mul % 10);
        }
        if (c != 0)
            str.append(c);
        return str.reverse().toString();
    }

    private String sum(List<String> parts) {
        if (parts.size() == 0)
            return "0";
        String result = parts.get(0);
        for (int i = 1; i < parts.size(); i++) {
            result = sum(result, parts.get(i));
        }
        return result;
    }

    private String sum(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int c = 0;
        int len = Math.max(num1.length(), num2.length());
        for (int i = 0; i < len; i++) {
            int a = num1.length() - i - 1 < 0 ? 0 : num1.charAt(num1.length() - i - 1) - '0';
            int b = num2.length() - i - 1 < 0 ? 0 : num2.charAt(num2.length() - i - 1) - '0';
            int s = a + b + c;
            c = s > 9 ? 1 : 0;
            str.append(s % 10);
        }
        if (c != 0)
            str.append(c);
        return str.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
    
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
    
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
    
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0))
                sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
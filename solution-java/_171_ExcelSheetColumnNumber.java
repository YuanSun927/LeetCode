package com.yuan.leetcode;

public class _171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += (s.charAt(s.length() - i - 1) - 64) * Math.pow(26, i); 
        }
        return num;
    }
    
    public int titleToNumber1(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num *= 26;
            num += s.charAt(i) - 'A' + 1; 
        }
        return num;
    }
    
    public static void main(String[] args) {
        System.out.println(new _171_ExcelSheetColumnNumber().titleToNumber1("AB"));
    }
}

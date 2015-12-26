/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/
public class _168_ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        String title = "";
        while (n > 0) {
            title = ((char) ((n - 1) % 26 + 'A')) + title;
            n = (n - 1) / 26; 
        }
        return title;
    }
}
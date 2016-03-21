/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
public class _17_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return result;
        String[] buttons = new String[] {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};    
        StringBuilder str = new StringBuilder();
        letterCombinations(digits, buttons, 0, str, result);
        return result;
    }

    private void letterCombinations(String digits, String[] buttons, int pos, StringBuilder str, List<String> result) {
        if (pos == digits.length()) {
            result.add(str.toString());
            return;
        }
        String btnLetters = buttons[digits.charAt(pos) - '0'];
        for (int i = 0; i < btnLetters.length(); i++) {
            str.append(btnLetters.charAt(i));
            letterCombinations(digits, buttons, pos + 1, str, result);
            str.deleteCharAt(pos);
        }
    }

}
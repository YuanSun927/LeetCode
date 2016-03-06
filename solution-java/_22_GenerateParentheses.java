/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
public class _22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        if (n < 1)
            return result;
        generate("", n, n, result);
        return result;
    }

    public void generate(String str, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > 0) {
            generate(str + '(', left - 1, right, result);
        }
        if (right > 0 && left < right) {
            generate(str + ')', left, right - 1, result);
        }
    }
}
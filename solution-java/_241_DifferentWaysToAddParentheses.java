/*
Given a string of numbers and operators, return all possible results from
computing all the different possible ways to group numbers and operators.
The valid operators are +, - and *.

Example 1
Input: "2-1-1".
((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]

Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/
public class _241_DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                // substring may be expensive.
                // JDK 6 Share the original string, just change the offset, charCount
                // JDK 7 Create a new string, so it is more expensive.
                List<Integer> part1 = diffWaysToCompute(input.substring(0, i)); 
                List<Integer> part2 = diffWaysToCompute(input.substring(i + 1));
                for (Integer p1 : part1) {
                    for (Integer p2 : part2) {
                        switch (cur) {
                            case '+':
                                result.add(p1 + p2);
                                break;
                            case '-':
                                result.add(p1 - p2);
                                break;
                            case '*':
                                result.add(p1 * p2);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }

    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input, 0, input.length());
    }

    private List<Integer> diffWaysToCompute(String input, int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                List<Integer> part1 = diffWaysToCompute(input, start, i);
                List<Integer> part2 = diffWaysToCompute(input, i + 1, end);
                for (Integer p1 : part1) {
                    for (Integer p2 : part2) {
                        switch (cur) {
                            case '+':
                                result.add(p1 + p2);
                                break;
                            case '-':
                                result.add(p1 - p2);
                                break;
                            case '*':
                                result.add(p1 * p2);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input.substring(start, end)));
        }
        return result;
    }

}
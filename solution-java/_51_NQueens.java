/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
public class _51_NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n < 1)
            return result;
        List<String> temp = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueens(board, 0, result);
        return result;
    }

    private void solveNQueens(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            addSolutionToResult(board, result);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                solveNQueens(board, row + 1, result);
                board[row][i] = '.';
            }
        }
    }

    private void addSolutionToResult(char[][] board, List<List<String>> result) {
        List<String> solution = new ArrayList<>(board.length);
        for (int i = 0; i < board.length; i++) {
            // 注意此处用了String(char[] data)构造函数
            // 若通过横纵遍历board[][]构造字符串可能会超时
            solution.add(new String(board[i])); 
        }
        result.add(solution);
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
            if (col - i - 1>= 0 && board[row - i - 1][col - i - 1] == 'Q')
                return false;
            if (col + i + 1< board.length && board[row - i - 1][col + i + 1] == 'Q')
                return false;
        }
        return true;
    }
}
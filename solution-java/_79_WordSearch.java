/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class _79_WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0)
            return false;
        boolean[][] isSearched = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isSearched[i][j] = true;
                    if (exist(board, i, j, word, 1, isSearched))
                        return true;
                    isSearched[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int col, String word, int i, boolean[][] isSearched) {
        if (i == word.length())
            return true;
        boolean isExisted = false;
        char cur = word.charAt(i);
        if (row > 0 && !isSearched[row - 1][col] && board[row - 1][col] == cur) {
            isSearched[row - 1][col] = true;
            isExisted = exist(board, row - 1, col, word, i + 1, isSearched);
            isSearched[row - 1][col] = false;
        }
        if (!isExisted && row < board.length - 1 && !isSearched[row + 1][col] && board[row + 1][col] == cur) {
            isSearched[row + 1][col] = true;
            isExisted = exist(board, row + 1, col, word, i + 1, isSearched);
            isSearched[row + 1][col] = false;
        }
        if (!isExisted && col > 0 && !isSearched[row][col - 1] && board[row][col - 1] == cur) {
            isSearched[row][col - 1] = true;
            isExisted = exist(board, row, col - 1, word, i + 1, isSearched);
            isSearched[row][col - 1] = false;
        }
        if (!isExisted && col < board[0].length - 1 && !isSearched[row][col + 1] && board[row][col + 1] == cur) {
            isSearched[row][col + 1] = true;
            isExisted = exist(board, row, col + 1, word, i + 1, isSearched);
            isSearched[row][col + 1] = false;
        }
        return isExisted;
    }

    // 思路一样，代码实现更简洁
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0)
            return false;
        boolean[][] isSearched = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0, isSearched))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int col, String word, int i, boolean[][] isSearched) {
        if (i == word.length())
            return true;
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || isSearched[row][col] || board[row][col] != word.charAt(i))
            return false;
        isSearched[row][col] = true;
        boolean isExisted = exist(board, row - 1, col, word, i + 1, isSearched)
                         || exist(board, row + 1, col, word, i + 1, isSearched)
                         || exist(board, row, col - 1, word, i + 1, isSearched)
                         || exist(board, row, col + 1, word, i + 1, isSearched);
        isSearched[row][col] = false;
        return isExisted;
    }

    // 省去isSearched数组，通过改变当前字符来标识该字符为搜索结果一部分。
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int col, String word, int i) {
        if (i == word.length())
            return true;
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(i))
            return false;
        board[row][col] = '$';
        boolean isExisted = exist(board, row - 1, col, word, i + 1)
                         || exist(board, row + 1, col, word, i + 1)
                         || exist(board, row, col - 1, word, i + 1)
                         || exist(board, row, col + 1, word, i + 1);
        board[row][col] = word.charAt(i);
        return isExisted;
    }
}
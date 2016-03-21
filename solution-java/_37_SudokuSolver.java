/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/
public class _37_SudokuSolver {

    // Time 9^4
    // Space O(1)
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    private boolean solveSudoku(char[][] board, int index) {
        for (int i = index; i < 81; i++) {
            int row = i / 9;
            int col = i % 9;
            if (board[row][col] == '.') {
                for (char c = '1'; c <= '9'; c++) {
                    board[row][col] = c;
                    if (isValid(board, row, col) && solveSudoku(board, i + 1))
                        return true;
                    board[row][col] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == board[row][col])
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == board[row][col])
                return false;
        }
        int topRow = row / 3 * 3;
        int leftCol = col / 3 * 3;
        for (int i = topRow; i < topRow + 3; i++) {
            for (int j = leftCol; j < leftCol + 3; j++) {
                if ((i != row || j != col) && board[i][j] == board[row][col])
                    return false;
            }
        }
        return true;
    }

    // Time 9^3
    // Space 9^2
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                addToSet(board, i, j, rows, cols, blocks);
            }
        }
        solveSudoku(board, 0, rows, cols, blocks);
    }

    private boolean solveSudoku(char[][] board, int index, boolean[][] rows, boolean[][] cols, boolean[][] blocks) {
        for (int i = index; i < 81; i++) {
            int row = i / 9;
            int col = i % 9;
            if (board[row][col] == '.') {
                for (char c = '1'; c <= '9'; c++) {
                    board[row][col] = c;
                    if (isValid(board, row, col, rows, cols, blocks)) {
                        addToSet(board, row, col, rows, cols, blocks);
                        if (solveSudoku(board, i + 1, rows, cols, blocks))
                            return true;
                        removeFromSet(board, row, col, rows, cols, blocks);
                    }
                    board[row][col] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, boolean[][] rows, boolean[][] cols, boolean[][] blocks) {
        int num = board[row][col] - '1';
        return !(rows[row][num] || cols[col][num] || blocks[row / 3 * 3 + col / 3][num]);
    }

    private void addToSet(char[][] board, int row, int col, boolean[][] rows, boolean[][] cols, boolean[][] blocks) {
        int num = board[row][col] - '1';
        rows[row][num] = true;
        cols[col][num] = true;
        blocks[row / 3 * 3 + col / 3][num] = true;
    }

    private void removeFromSet(char[][] board, int row, int col, boolean[][] rows, boolean[][] cols, boolean[][] blocks) {
        int num = board[row][col] - '1';
        rows[row][num] = false;
        cols[col][num] = false;
        blocks[row / 3 * 3 + col / 3][num] = false;
    }
}
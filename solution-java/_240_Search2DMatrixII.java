/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/
public class _240_Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        final int height = matrix.length;
        final int width = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[height - 1][width - 1])
            return false;
        int delta = (height - 1) / 4;
        int startRow = delta;
        while (delta >= 0) {
            if (target == matrix[startRow][0])
                return true;
            if (target > matrix[startRow][0])
                startRow = startRow - delta;
            else
                startRow = startRow + delta;
            delta /= 2;
        }
        delta = (height - 1) / 4;
        int endRow = delta;
        while (delta >= 0) {
            if (target == matrix[endRow][width - 1])
                return true;
            if (target > matrix[startRow][width - 1])
                endRow = endRow - delta;
            else
                endRow = endRow + delta;
            delta /= 2;
        }
        int low = 0;
        int high = width - 1;
        int mid = 0;
        for (int i = startRow; i <= endRow; i++) {
            while (low <= high) {
                mid = low + ((high - low) >> 1);
                if (target == matrix[i][mid])
                    return true;
                if (target < matrix[i][mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col])
                return true;
            if (target < matrix[row][col]) {
                col = col - 1;
            } else {
                row = row + 1;
            }
        }
        return false;
    }
}

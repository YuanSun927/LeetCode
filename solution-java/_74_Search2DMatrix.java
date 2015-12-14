/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class _74_Search2DMatrix {

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        final int height = matrix.length;
        final int width = matrix[0].length;
        int low = 0;
        int high = height - 1;
        int mid = 0;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (target == matrix[mid][0])
                return true;
            if (target < matrix[mid][0])
                high = mid - 1;
            else if (target > matrix[mid][0] && target <= matrix[mid][width - 1]) {
                low = mid;
                break;
            } else {
                low = mid + 1;
            }
        }
        final int row = low;
        low = 0;
        high = width - 1;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (target == matrix[row][mid])
                return true;
            if (target < matrix[row][mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    /**
     * Not perfect. height * width may overflow.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        final int height = matrix.length;
        final int width = matrix[0].length;
        int low = 0;
        int high = height * width - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            int val = matrix[mid / width][mid % width];
            if (val == target)
                return true;
            if (val > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }  
}

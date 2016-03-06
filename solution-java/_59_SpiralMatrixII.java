/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class _59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int lt = 0, br = n - 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = lt; j < br; j++) {
                matrix[lt][j] = num++;
            }
            for (int j = lt; j < br; j++) {
                matrix[j][br] = num++;
            }
            for (int j = br; j > lt; j--) {
                matrix[br][j] = num++;
            }
            for (int j = br; j > lt; j--) {
                matrix[j][lt] = num++;
            }
            lt++;
            br--;
        }
        if (n % 2 == 1)
            matrix[lt][lt] = num;
        return matrix;
    }
}
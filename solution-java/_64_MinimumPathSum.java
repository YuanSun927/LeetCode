/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class _64_MinimumPathSum {
    
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int[][] path = new int[height][width];
        path[0][0] = grid[0][0];
        for (int i = 1; i < width; i++) {
            path[0][i] = path[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < height; i++) {
            path[i][0] = path[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
            }
        }
        return path[height - 1][width - 1];
    } 
}

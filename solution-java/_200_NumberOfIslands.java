/*
200. Number of Islands My Submissions Question
Total Accepted: 29723 Total Submissions: 117024 Difficulty: Medium
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/
public class _200_NumberOfIslands {

    private boolean[][] isVisited;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int count = 0;
        isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        isVisited[i][j] = true;
        if (i > 0 && grid[i - 1][j] == '1' && !isVisited[i - 1][j])
            dfs(grid, i - 1, j);
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && !isVisited[i + 1][j])
            dfs(grid, i + 1, j);
        if (j > 0 && grid[i][j - 1] == '1' && !isVisited[i][j - 1])
            dfs(grid, i, j - 1);
        if (j < grid[i].length - 1 && grid[i][j + 1] == '1' && !isVisited[i][j + 1])
            dfs(grid, i, j + 1);
    }
}
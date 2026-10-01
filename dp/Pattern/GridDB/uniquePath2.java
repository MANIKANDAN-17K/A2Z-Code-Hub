/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/
class Solution {
    private int solve(
        int i,int j,int m,int n,int[][] grid
    ){
        if(i >= m || j >= n) return 0;
        if(grid[i][j] == 1) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        int path = 0;
        if(i + 1 < m) path += solve(i + 1,j,m,n,grid);
        if(j +1 < n) path += solve(i,j+1,m,n,grid);
        return path;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return solve(0,0,n,m,grid);
    }
}

class Solution {
    private int solve(
        int i,int j,int m,int n,int[][] grid,int[][] dp
    ){
        if(i >= m || j >= n) return 0;
        if(grid[i][j] == 1) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int path = 0;
        
        if(i + 1 < m) path += solve(i + 1,j,m,n,grid,dp);
        if(j +1 < n) path += solve(i,j+1,m,n,grid,dp);
        dp[i][j] = path;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return solve(0,0,n,m,grid,dp);
    }
}

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 200
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(grid, 0, 0, m, n);
    }
    private int solve(int[][] grid, int i,int j,int m, int n) {
        if (i == m - 1 && j == n - 1) return grid[i][j];
        if (i >= m || j >= n) return 1_000_000_000;
        int down = solve(grid, i + 1, j, m, n);
        int right = solve(grid, i, j + 1, m, n);
        return grid[i][j] + Math.min(down, right);
    }
}

class Solution {
    private int solve(int i,int j,int m,int n,int[][] grid,int[][] dp){
        if(i == m - 1 && j == n - 1) return grid[i][j];
        if(i >= m || j >= n) return 1_000_000_000;
        if(dp[i][j] != -1) return dp[i][j];
        int right = solve(i,j+1,m,n,grid,dp);
        int down = solve(i+1,j,m,n,grid,dp);
        dp[i][j] = Math.min(right,down) + grid[i][j];
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        return solve(0,0,n,m,grid,dp);
    }
}

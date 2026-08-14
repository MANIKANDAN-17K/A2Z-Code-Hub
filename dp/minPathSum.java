/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12


*/


class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return minPath(grid,0,0,dp);
    }
    private int minPath(int[][] grid,int x,int y,int[][] dp){
        int n = grid.length;
        int m = grid[0].length;
        if(x >= n || y >= m) return Integer.MAX_VALUE;
        if(x == n - 1 && y == m - 1) return grid[x][y];
        if(dp[x][y] != -1) return dp[x][y];
        int right = minPath(grid,x+1,y,dp);
        int down = minPath(grid,x,y+1,dp);
        return dp[x][y] = Math.min(right,down) + grid[x][y];
    }
}

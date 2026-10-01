
/*
221. Maximal Square

Given an m x n binary matrix filled with 0's and 1's,
find the largest square containing only 1's and return
its area.

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4


"I define solve(i,j) as the maximum side length of a 
square starting at cell (i,j). If the current cell is 0,
I cannot form a square, so I return 0. If it is 1, 
I need to check the maximum square that can be formed 
to the right, below, and diagonally below-right. 
The current square can only grow as large as the 
smallest of those three values, so the recurrence 
is 1 + min(right, down, diagonal). Since the largest
square can start at any cell, I evaluate every cell
and maintain a global maximum. Because the same cells
are calculated repeatedly, I use memoization."

*/

class Solution {
    private int maxSide = 0;
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                solve(i,j,n,m,matrix);
            }
        }
        return maxSide * maxSide;
    }
    private int solve(int i,int j,int n,int m,char[][] matrix){
        if(i >= n || j >= m) return 0;
        if(matrix[i][j] == '0' ) return 0;
        int right = solve(i,j+1,n,m,matrix);
        int down = solve(i+1,j,n,m,matrix);
        int diagonal = solve(i+1,j+1,n,m,matrix);
        int cur = Math.min(Math.min(right,down),diagonal) + 1;
        maxSide = Math.max(cur,maxSide);
        return cur;

    }
}

class Solution {
    private int maxSide = 0;
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                solve(i,j,n,m,matrix,dp);
            }
        }
        return maxSide * maxSide;
    }


    private int solve(int i,int j,int n,int m,char[][] matrix,int[][] dp){
        if(i >= n || j >= m) return 0;
        if(matrix[i][j] == '0' ) return 0;
        if(dp[i][j] != -1 ) return dp[i][j];
        int right = solve(i,j+1,n,m,matrix,dp);
        int down = solve(i+1,j,n,m,matrix,dp);
        int diagonal = solve(i+1,j+1,n,m,matrix,dp);
        int cur = Math.min(Math.min(right,down),diagonal) + 1;
        maxSide = Math.max(cur,maxSide);
        dp[i][j] = cur;
        return cur;

    }
}

/*
62. Unique Paths
Solved
Medium
Topics
premium lock iconCompanies

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:

Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

 

Constraints:

    1 <= m, n <= 100

"At every cell, I have two possible moves: right or down.
After making either move, I have the same problem starting 
from the new cell. Therefore, I can recursively calculate 
the number of paths from each cell. If I reach the 
destination, that's one valid path, so I return 1.
The recurrence is ways(i,j) = ways(i+1,j) + ways(i,j+1). 
Since the same cells can be reached through different paths,
there are overlapping subproblems, so I use a 2D
memoization array to store the result for each cell."


*/

class Solution {
    private int solve(int i,int j,int m,int n){
        if(i == m-1 && j == n -1) return 1;
        int path = 0;
        if(i+1 < m) path += solve(i+1,j,m,n);
        if(j+1 < n) path += solve(i,j+1,m,n);
        return path;
    }
    public int uniquePaths(int m, int n) {
        return solve(0,0,m,n);
    }
   
}

class Solution {
    private int solve(int i,int j,int m,int n,int dp[][]){
        if(i == m-1 && j == n -1) return 1;
        if(dp[i][j]!= -1) return dp[i][j];
        int path = 0;

        if(i+1 < m) path += solve(i+1,j,m,n,dp);
        if(j+1 < n) path += solve(i,j+1,m,n,dp);
        dp[i][j] = path;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] d : dp)
        {Arrays.fill(d,-1);}
        return solve(0,0,m,n,dp);
    }
   
}

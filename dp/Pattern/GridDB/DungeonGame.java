/*
174. Dungeon Game

The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).

To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Return the knight's minimum initial health so that he can rescue the princess.

Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

 

Example 1:

Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.

Example 2:

Input: dungeon = [[0]]
Output: 1

 

Constraints:

    m == dungeon.length
    n == dungeon[i].length
    1 <= m, n <= 200
    -1000 <= dungeon[i][j] <= 1000

*/

class Solution {
    private int solve(int i,int j,int[][] A){
        int n = A.length;
        int m = A[0].length;
        if(i == n -1 && j == m - 1)
            return Math.max(1,1 - A[i][j]);
        if(i >= n || j >= m)
            return Integer.MAX_VALUE;
        int right = solve(i,j+1,A);
        int down = solve(i+1,j,A);
        int next = Math.min(right,down);
        return Math.max(1, next - A[i][j]);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        return solve(0,0,dungeon);
    }
}

class Solution {
    private int solve(int i,int j,int[][] A,int[][] dp){
        int n = A.length;
        int m = A[0].length;
        if(i == n -1 && j == m - 1)
            return Math.max(1,1 - A[i][j]);
        if(i >= n || j >= m)
            return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        int right = solve(i,j+1,A,dp);
        int down = solve(i+1,j,A,dp);
        int next = Math.min(right,down);
        dp[i][j] = Math.max(1, next - A[i][j]);
        return dp[i][j];
    }
    public int calculateMinimumHP(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return solve(0,0,A,dp);
    }
}
